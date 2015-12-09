package br.com.util;

import java.util.ArrayList;
import java.util.List;

import br.com.persistence.dao.CellularDAO;
import br.com.persistence.dao.SpecificationDAO;
import br.com.persistence.dao.SpecificationTypeDAO;
import br.com.persistence.entity.Cellular;
import br.com.persistence.entity.Specification;
import br.com.persistence.entity.SpecificationType;

/**
 * Classe de inicialização do banco de dados.
 * Cadastra todas as informações a serem utilizadas pelo sistema.
 * 
 * @author Juliana
 */
public class InitDB {

	private CellularDAO cellDAO;
	private SpecificationTypeDAO specTypeDAO;
	private SpecificationDAO specDAO;
	
	public InitDB(CellularDAO cellDAO, SpecificationDAO specDAO, SpecificationTypeDAO specTypeDAO) {
		this.cellDAO = cellDAO;
		this.specDAO = specDAO;
		this.specTypeDAO = specTypeDAO;
	}
	
	public void fillDB() {
		addSpecification();
		addCellPhones();
	}
	
	private void addSpecification(){
		List<Specification> specifications = specDAO.list();
		
		if(specifications == null || specifications.isEmpty()){
			saveProcSpecification();
			saveMemSpecification();
			saveRamSpecification();
			saveCameraSpecification();
			savePriceSpecification();
		}
		
	}
	
	private void saveProcSpecification(){
		SpecificationType proc = new SpecificationType("PROC", "Processador");
		proc = specTypeDAO.save(proc);
		
		Specification specP7 = new Specification("QC15QC2", "Quad-core 1.5 GHz Cortex-A53 + Quad-core 2 GHz Cortex-A57", 1, proc);
		specDAO.save(specP7);
		
		Specification specP1 = new Specification("QC27", "2.7 GHz Quad Core", 2, proc);
		specDAO.save(specP1);
		
		Specification specP2 = new Specification("QC25", "2.5 GHz Quad Core", 3, proc);
		specDAO.save(specP2);
		
		Specification specP3 = new Specification("QC23", "2.3 GHz Quad Core", 4, proc);
		specDAO.save(specP3);
		
		Specification specP4 = new Specification("QC12", "1.2 GHz Quad Core", 5, proc);
		specDAO.save(specP4);
		
		Specification specP5 = new Specification("DC2", "2 GHz Dual Core", 6, proc);
		specDAO.save(specP5);
		
		Specification specP8 = new Specification("DC13", "1.3 GHz Dual Core", 7, proc);
		specDAO.save(specP8);
		
		Specification specP6 = new Specification("DC12", "1.2 GHz Dual Core", 8, proc);
		specDAO.save(specP6);
	}
	
	private void saveMemSpecification(){
		SpecificationType mem = new SpecificationType("MEM", "Memória");
		mem = specTypeDAO.save(mem);
		
		Specification specM1 = new Specification("128GB", "128 GB", 1, mem);
		specDAO.save(specM1);
		
		Specification specM2 = new Specification("64GB", "64 GB", 2, mem);
		specDAO.save(specM2);
		
		Specification specM3 = new Specification("32GB", "32 GB", 3, mem);
		specDAO.save(specM3);
		
		Specification specM4 = new Specification("16GB", "16 GB", 4, mem);
		specDAO.save(specM4);
		
		Specification specM5 = new Specification("8GB", "8 GB", 5, mem);
		specDAO.save(specM5);
	}
	
	private void saveRamSpecification(){
		SpecificationType ram = new SpecificationType("RAM", "RAM");
		ram = specTypeDAO.save(ram);
		
		Specification specR1 = new Specification("3GB", "3 GB", 1, ram);
		specDAO.save(specR1);
		
		Specification specR2 = new Specification("2GB", "2 GB", 2, ram);
		specDAO.save(specR2);
		
		Specification specR3= new Specification("1GB", "1 GB", 3, ram);
		specDAO.save(specR3);
	}
	
	private void saveCameraSpecification(){
		SpecificationType cam = new SpecificationType("CAMPIX", "Câmera Pixels");
		cam = specTypeDAO.save(cam);
		
		Specification specC5 = new Specification("23MP", "23 Mp", 1, cam);
		specDAO.save(specC5);
		
		Specification specC1 = new Specification("21MP", "21 Mp", 2, cam);
		specDAO.save(specC1);
		
		Specification specC2 = new Specification("16MP", "16 Mp", 3, cam);
		specDAO.save(specC2);
		
		Specification specC6 = new Specification("13MP", "13 Mp", 4, cam);
		specDAO.save(specC6);
		
		Specification specC3 = new Specification("12MP", "12 Mp", 5, cam);
		specDAO.save(specC3);
		
		Specification specC4 = new Specification("8MP", "8 Mp", 6, cam);
		specDAO.save(specC4);
	}
	
	private void savePriceSpecification(){
		SpecificationType price = new SpecificationType("PREC", "Preço");
		price = specTypeDAO.save(price);
		
		Specification specR7 = new Specification("3482P", "R$ 3.482,00", 10, price);
		specDAO.save(specR7);
		
		Specification specR1 = new Specification("3299P", "R$ 3.299,00", 9, price);
		specDAO.save(specR1);
		
		Specification specR8 = new Specification("3149P", "R$ 3.149,00", 8, price);
		specDAO.save(specR8);
		
		Specification specR2 = new Specification("1943P", "R$ 1.943,00", 7, price);
		specDAO.save(specR2);
		
		Specification specR3 = new Specification("1799P", "R$ 1.799,00", 6, price);
		specDAO.save(specR3);
		
		Specification specR9 = new Specification("1139P", "R$ 1.139,00", 5, price);
		specDAO.save(specR9);
		
		Specification specR10 = new Specification("899P", "R$ 899,00", 4, price);
		specDAO.save(specR10);
		
		Specification specR4 = new Specification("854P", "R$ 854,00", 3, price);
		specDAO.save(specR4);
		
		Specification specR5 = new Specification("759P", "R$ 759,00", 2, price);
		specDAO.save(specR5);
		
		Specification specR6 = new Specification("606P", "R$ 606,00", 1, price);
		specDAO.save(specR6);
	}

	private void addCellPhones() {
		List<Cellular> cellulars = cellDAO.list(false);

		if (cellulars == null || cellulars.isEmpty()) {
			List<Cellular> newCells = new ArrayList<>();

			Cellular c1 = new Cellular("Motorola Moto Maxx", "motorola_moto_maxx.jpg", 0);
			Specification proc27 = specDAO.find("QC27");
			Specification ram3 = specDAO.find("3GB");
			Specification mem64 = specDAO.find("64GB");
			Specification cam21 = specDAO.find("21MP");
			Specification price1943 = specDAO.find("1943P");
			
			List<Specification> specifications1 = new ArrayList<>();
			specifications1.add(price1943);
			specifications1.add(proc27);
			specifications1.add(ram3);
			specifications1.add(mem64);
			specifications1.add(cam21);
			
			c1.setSpecs(specifications1);
			
			Cellular c2 = new Cellular("Samsung Galaxy S5", "samsung_galaxy_s5.jpg", 0);
			Specification proc25 = specDAO.find("QC25");
			Specification ram2 = specDAO.find("2GB");
			Specification mem16 = specDAO.find("16GB");
			Specification cam16 = specDAO.find("16MP");
			Specification price854 = specDAO.find("854P");
			
			List<Specification> specifications2 = new ArrayList<>();
			specifications2.add(price854);
			specifications2.add(proc25);
			specifications2.add(ram2);
			specifications2.add(mem16);
			specifications2.add(cam16);
			
			c2.setSpecs(specifications2);
			
			Cellular c3 = new Cellular("LG Nexus 5", "lg_nexus_5.jpg", 0);
			Specification proc23 = specDAO.find("QC23");
			Specification mem32 = specDAO.find("32GB");
			Specification cam8 = specDAO.find("8MP");
			Specification price1799 = specDAO.find("1799P");
			
			List<Specification> specifications3 = new ArrayList<>();
			specifications3.add(price1799);
			specifications3.add(proc23);
			specifications3.add(ram2);
			specifications3.add(mem32);
			specifications3.add(cam8);
			
			c3.setSpecs(specifications3);
			
			Cellular c4 = new Cellular("Asus Zenfone 5", "asus_zenfone_5.jpg", 0);
			Specification proc12 = specDAO.find("DC12");
			Specification mem8 = specDAO.find("8GB");
			Specification price606 = specDAO.find("606P");
			
			List<Specification> specifications4 = new ArrayList<>();
			specifications4.add(price606);
			specifications4.add(proc12);
			specifications4.add(ram2);
			specifications4.add(mem8);
			specifications4.add(cam8);
			
			c4.setSpecs(specifications4);
			
			Cellular c5 = new Cellular("Apple iPhone 6s", "apple_iphone_6s.jpg", 0);
			Specification proc2 = specDAO.find("DC2");
			Specification mem128 = specDAO.find("128GB");
			Specification cam12 = specDAO.find("12MP");
			Specification price3299 = specDAO.find("3299P");
			
			List<Specification> specifications5 = new ArrayList<>();
			specifications5.add(price3299);
			specifications5.add(proc2);
			specifications5.add(ram2);
			specifications5.add(mem128);
			specifications5.add(cam12);
			
			c5.setSpecs(specifications5);
			
			Cellular c6 = new Cellular("Samsung Galaxy A3", "samsung_galaxy_a3.jpg", 0);
			Specification proc12qc = specDAO.find("QC12");
			Specification ram1 = specDAO.find("1GB");
			Specification price759 = specDAO.find("759P");
			
			List<Specification> specifications6 = new ArrayList<>();
			specifications6.add(price759);
			specifications6.add(proc12qc);
			specifications6.add(ram1);
			specifications6.add(mem16);
			specifications6.add(cam8);
			
			c6.setSpecs(specifications6);
			
			Cellular c7 = new Cellular("Sony Xperia Z5", "sony_xperia_z5.jpg", 0);
			Specification proc152 = specDAO.find("QC15QC2");
			Specification cam23 = specDAO.find("23MP");
			Specification price3482 = specDAO.find("3482P");
			
			List<Specification> specifications7 = new ArrayList<>();
			specifications7.add(price3482);
			specifications7.add(proc152);
			specifications7.add(ram3);
			specifications7.add(mem32);
			specifications7.add(cam23);
			
			c7.setSpecs(specifications7);
			
			Cellular c8 = new Cellular("Motorola Moto X Force", "motorola_moto_x_force.jpg", 0);
			Specification price3149 = specDAO.find("3149P");
			
			List<Specification> specifications8 = new ArrayList<>();
			specifications8.add(price3149);
			specifications8.add(proc152);
			specifications8.add(ram3);
			specifications8.add(mem64);
			specifications8.add(cam21);
			
			c8.setSpecs(specifications8);
			
			Cellular c9 = new Cellular("LG G4 Beat", "lg_g4_beat.jpg", 0);
			Specification cam13 = specDAO.find("13MP");
			Specification price899 = specDAO.find("899P");
			
			List<Specification> specifications9 = new ArrayList<>();
			specifications9.add(price899);
			specifications9.add(proc152);
			specifications9.add(ram1);
			specifications9.add(mem8);
			specifications9.add(cam13);
			
			c9.setSpecs(specifications9);
			
			Cellular c10 = new Cellular("Apple iPhone 5C", "apple_iphone_5c.jpg", 0);
			Specification proc13dc = specDAO.find("DC13");
			Specification price1139 = specDAO.find("1139P");
			
			List<Specification> specifications10 = new ArrayList<>();
			specifications10.add(price1139);
			specifications10.add(proc13dc);
			specifications10.add(ram1);
			specifications10.add(mem32);
			specifications10.add(cam8);
			
			c10.setSpecs(specifications10);

			newCells.add(c1);
			newCells.add(c2);
			newCells.add(c3);
			newCells.add(c4);
			newCells.add(c5);
			newCells.add(c6);
			newCells.add(c7);
			newCells.add(c8);
			newCells.add(c9);
			newCells.add(c10);

			for (Cellular c : newCells) {
				cellDAO.save(c);
			}

		}
	}

}
