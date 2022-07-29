package com.sutanrrier.desafiospring.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sutanrrier.desafiospring.entities.Carro;
import com.sutanrrier.desafiospring.repositories.CarroRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public String gerarRelatorioByEstacionamento(Integer id) {
		try {
			String pathRelatorio = "src/main/java/com/sutanrrier/desafiospring/rel/report2.jrxml";
			String pathPDF = "C:/Users/Pablo/Desktop/Relatorio/carros.pdf";
			
			JasperReport relatorioCompilado = JasperCompileManager.compileReport(pathRelatorio);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repository.findAllByEstacionamento(id));
			JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, ds);

			JasperExportManager.exportReportToPdfFile(relatorioPreenchido, pathPDF);
			
			return "Relatório Gerado com sucesso!";
		}
		catch(JRException e) {
			System.out.println("Erro ao gerar relatorio " + e.getMessage());
		}
		return "Ocorreu um erro!";
	}
	
	public String gerarRelatorioAllCarros() {
		try {
			String pathRelatorio = "src/main/java/com/sutanrrier/desafiospring/rel/report2.jrxml";
			String pathPDF = "C:/Users/Pablo/Desktop/Relatorio/carros.pdf";
			
			JasperReport relatorioCompilado = JasperCompileManager.compileReport(pathRelatorio);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getAllCarros());
			JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, ds);

			JasperExportManager.exportReportToPdfFile(relatorioPreenchido, pathPDF);
			
			return "Relatório Gerado com sucesso!";
		}
		catch(JRException e) {
			System.out.println("Erro ao gerar relatorio " + e.getMessage());
		}
		return "Ocorreu um erro!";
	}
	
	public List<Carro> getAllCarros(){
		return repository.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public Page<Carro> findAll(Integer page){
		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(page, 5, sort);
		
		return repository.findAll(pageable);
	}
	
	public Optional<Carro> findById(Integer id) {
		return repository.findById(id);
	}
	
	@Transactional
	public Carro save(Carro carro) {
		return repository.save(carro);
	}
	
	@Transactional
	public void delete(Carro carro) {
		repository.delete(carro);
	}

}
