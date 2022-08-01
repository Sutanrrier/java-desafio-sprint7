package com.sutanrrier.desafiospring.services;

import java.io.FileInputStream;
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

	public byte[] gerarRelatorioByEstacionamento(Integer id) {
		try {
			FileInputStream pathRelatorio = new FileInputStream("src/main/resources/report2.jrxml");

			JasperReport relatorioCompilado = JasperCompileManager.compileReport(pathRelatorio);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repository.findAllByEstacionamento(id));
			JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, ds);
			
			byte[] data = JasperExportManager.exportReportToPdf(relatorioPreenchido);

			return data;
		} catch (Exception e) {
			System.out.println("Erro ao gerar relatorio " + e.getMessage());
		}
		return null;
	}

	public byte[] gerarRelatorioAllCarros() {
		try {
			FileInputStream pathRelatorio = new FileInputStream("src/main/resources/report2.jrxml");
			
			JasperReport relatorioCompilado = JasperCompileManager.compileReport(pathRelatorio);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getAllCarros());
			JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, ds);
			
			byte[] data = JasperExportManager.exportReportToPdf(relatorioPreenchido);

			return data;

		} catch (Exception e) {
			System.out.println("Erro ao gerar relatorio " + e.getMessage());
		}
		return null;
	}

	public List<Carro> getAllCarros() {
		return repository.findAll(Sort.by(Direction.ASC, "id"));
	}

	public Page<Carro> findAll(Integer page) {
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
