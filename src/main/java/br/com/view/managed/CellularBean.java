package br.com.view.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controller.CellularControllerLocal;
import br.com.controller.SpecificationTypeControllerLocal;
import br.com.exception.NullParameterException;
import br.com.persistence.entity.Cellular;
import br.com.persistence.entity.Specification;
import br.com.persistence.entity.SpecificationType;
import br.com.view.util.ViewUtil;

@ManagedBean
@ViewScoped
public class CellularBean implements Serializable {

	private static final long serialVersionUID = 3266499017488346232L;

	public enum ViewState {
		CHOOSE_STATE, COMPARE_STATE, FAVOURITE_STATE
	}

	private ViewState state = ViewState.CHOOSE_STATE;

	@EJB
	private CellularControllerLocal cellularController;

	@EJB
	private SpecificationTypeControllerLocal specificationTypeController;

	private List<Cellular> cellulars;
	private Cellular cellular;
	private List<Cellular> selectedCellulars;

	private List<String> rowNames;
	private List<String> columnNames;

	@PostConstruct
	public void iniciar() {
		list();
	}

	public void list() {
		this.cellulars = cellularController.list(false);
	}
	
	public void prepareChoose(){
		setState(ViewState.CHOOSE_STATE);
		list();
		selectedCellulars = new ArrayList<>();
	}

	public void compare() {
		if (selectedCellulars != null && !selectedCellulars.isEmpty() && selectedCellulars.size() == 2) {
			setState(ViewState.COMPARE_STATE);
			fillRowsColumnsName();
		} else {
			String msg = "";
			if(selectedCellulars == null || selectedCellulars.isEmpty()){
				msg = "Selecione dois celulares para comparar";
			} else if(selectedCellulars.size() > 2){
				msg = "Só devem ser selecionados dois celulares para a comparação.";
			} else if(selectedCellulars.size() < 2) {
				msg = "Quantidade de celular selecionada inferior a aceitada";
			}
			ViewUtil.addErrorMessage(null, msg);
		}
	}

	private void fillRowsColumnsName() {
		columnNames = new ArrayList<>();
		rowNames = new ArrayList<>();

		for (Cellular selectedCellular : selectedCellulars) {
			columnNames.add(selectedCellular.getName());
		}

		List<SpecificationType> specificationsType = specificationTypeController.list();

		for (SpecificationType specType : specificationsType) {
			rowNames.add(specType.getName());
		}
	}

	public String getValue(String cellularName, String specificationTypeName) {
		for (Cellular c : selectedCellulars) {
			if (c.getName().equals(cellularName)) {
				List<Specification> specs = c.getSpecs();
				for (Specification spec : specs) {
					if (spec.getType().getName().equals(specificationTypeName)) {
						return spec.getValue();
					}
				}
				break;
			}
		}
		return "-";
	}

	public String highlight(String cellularName, String specificationTypeName) {

		int positionSelected = 0;
		int positionOther = 0;

		for (Cellular c : selectedCellulars) {
			List<Specification> specs = c.getSpecs();
			for (Specification spec : specs) {
				if (c.getName().equals(cellularName) && spec.getType().getName().equals(specificationTypeName)) {
					positionSelected = spec.getPosition();
				} else if (spec.getType().getName().equals(specificationTypeName)) {
					positionOther = spec.getPosition();
				}
			}
		}

		if (positionSelected < positionOther) {
			return "font-weight:bold; color:green;";
		}
		return "";

	}

	public void backChoose() {
		setState(ViewState.CHOOSE_STATE);
		list();
	}
	
	public void addFavourite(String cellularName){
		try {
			cellularController.addFavourite(cellularName);
			this.cellulars = cellularController.list(true);
			setState(ViewState.FAVOURITE_STATE);
		} catch (NullParameterException e) {
			ViewUtil.addErrorMessage(null, "Campos obrigatórios não preenchidos.");
			e.printStackTrace();
		}
	}
	
	public void cleanSelection(){
		selectedCellulars = new ArrayList<>();
	}

	public boolean isChooseState() {
		return state.equals(ViewState.CHOOSE_STATE);
	}

	public boolean isCompareState() {
		return state.equals(ViewState.COMPARE_STATE);
	}
	
	public boolean isFavouriteState() {
		return state.equals(ViewState.FAVOURITE_STATE);
	}

	public CellularControllerLocal getCellularController() {
		return cellularController;
	}

	public void setCellularController(CellularControllerLocal cellularController) {
		this.cellularController = cellularController;
	}

	public ViewState getState() {
		return state;
	}

	public void setState(ViewState state) {
		this.state = state;
	}

	public List<Cellular> getCellulars() {
		return cellulars;
	}

	public void setCellulars(List<Cellular> cellulars) {
		this.cellulars = cellulars;
	}

	public Cellular getCellular() {
		return cellular;
	}

	public void setCellular(Cellular cellular) {
		this.cellular = cellular;
	}

	public List<Cellular> getSelectedCellulars() {
		return selectedCellulars;
	}

	public void setSelectedCellulars(List<Cellular> selectedCellulars) {
		this.selectedCellulars = selectedCellulars;
	}

	public List<String> getRowNames() {
		return rowNames;
	}

	public void setRowNames(List<String> rowNames) {
		this.rowNames = rowNames;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

}
