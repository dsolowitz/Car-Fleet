import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing. *;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FleetFun {
	
	private Car car;
	private Fleet fleet;
	private JLabel carText;
	private JTextField carId;
	private JLabel milesText;
	private JTextField newMiles;
	private JLabel fuelText;
	private JTextField newFuel;
	private JButton newCar;
	private JLabel bestMPG;
	private JLabel highMiles;
	private JLabel fleetAvg;
	private JTextArea orderedFleet;
	private JTextArea orderedMPGFleet;
	private JButton delete;
	private JTextField deleteCar;
	private JButton editCar;
	private JTextField editField;
	private JLabel enterText;
	private JButton edit;
	private JLabel newName;
	private JLabel newMileage;
	private JLabel newFuelMiles;
	private String carToEdit;
	private JTextField newCarText;
	private JButton clickToEdit;
	private JButton clickToSave;
	private JButton clickToLoad;
	
	private JTextField newCarMiles;
	private JTextField newCarFuel;
	private JButton closeEditView;
	private WidgetView editWidget;
	private WidgetView wv;
	private EditView edits;
	
	
	
	public FleetFun() {
		
		wv = new WidgetView();
		
		fleet = new Fleet();
		newCar = new JButton("make a new car");
		bestMPG = new JLabel("Best MPG:");
		highMiles = new JLabel("Highest Mileage");
		fleetAvg = new JLabel("Fleet AVG MPG");
		orderedFleet = new JTextArea("Fleet as entered");
		orderedMPGFleet = new JTextArea("Fleet by MPG");
		carText = new JLabel("New Car Id");
		carId = new JTextField(10);
		milesText = new JLabel("New Car Mileage");
		newMiles = new JTextField(5);
		fuelText = new JLabel("New Car Fuel");
		newFuel = new JTextField(5);
		delete = new JButton("Click me to delete car by name");
		deleteCar = new JTextField(10);
		editCar = new JButton("Click me to edit car properties");
		clickToSave = new JButton("Save");
		clickToLoad = new JButton("Load");
		
		ButtonEvents action = new ButtonEvents(newCar);
		
		newCar.addActionListener(action);
		carId.addActionListener(action);
		newMiles.addActionListener(action);
		newFuel.addActionListener(action);
		delete.addActionListener(action);
		deleteCar.addActionListener(action);
		editCar.addActionListener(action);
		clickToSave.addActionListener(action);
		clickToLoad.addActionListener(action);
		
		wv.add(newCar);
		wv.add(carText);
		wv.add(carId);
		wv.add(milesText);
		wv.add(newMiles);
		wv.add(fuelText);
		wv.add(newFuel);
		wv.add(bestMPG);
		wv.add(highMiles);
		wv.add(fleetAvg);
		wv.add(orderedFleet);
		wv.add(orderedMPGFleet);
		wv.add(delete);
		wv.add(deleteCar);
		wv.add(editCar);
		wv.add(clickToSave);
		wv.add(clickToLoad);
		
	}
	
	
	
	class EditView {
		
		
		
		public EditView() {
		
		editWidget = new WidgetView();
		editField = new JTextField(10);
		enterText = new JLabel("Which car would you like to edit");
		newName = new JLabel("Type and enter here to update car name");
		newMileage = new JLabel("Type and enter here to update cars miles");
		newFuelMiles = new JLabel("Type and enter here to update cars fuel");
		edit = new JButton("Click to edit");
		newCarText = new JTextField(10);
		clickToEdit = new JButton("Click to Edit");
		closeEditView = new JButton("Click to stop editing");
		
		newCarMiles = new JTextField(10);
		newCarFuel = new JTextField(10);
		
		
		ButtonEvents action = new ButtonEvents(edit);
		edit.addActionListener(action);
		editField.addActionListener(action);
		newCarText.addActionListener(action);
		clickToEdit.addActionListener(action);
		closeEditView.addActionListener(action);
		newCarMiles.addActionListener(action);
		newCarFuel.addActionListener(action);
		
		editWidget.add(orderedFleet);
		editWidget.add(orderedMPGFleet);
		editWidget.add(enterText);
		editWidget.add(editField);
		editWidget.add(edit);
		orderedFleet.setText("Ordered Fleet: " + fleet.toString());
		editWidget.add(newName);
		editWidget.add(newCarText);
		editWidget.add(newMileage);
		editWidget.add(newCarMiles);
		editWidget.add(newFuelMiles);
		editWidget.add(newCarFuel);
		editWidget.add(closeEditView);
		}
		
		
	}
	
	class ButtonEvents extends WidgetViewActionEvent{
		public ButtonEvents(JButton pushMe) {
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()== newCar || e.getSource() == carId || e.getSource() == newMiles || e.getSource() == newFuel) {
			car = new Car();
			car.setIdentifier(carId.getText());
			car.setFuelUsed(Integer.parseInt(newFuel.getText()));
			car.setMiles(Integer.parseInt(newMiles.getText()));
			fleet.add(car);
			
			}
			
			else if (e.getSource() == delete || e.getSource() == deleteCar ) {
				
				fleet.delete(deleteCar.getText());
				deleteCar.setText("");
				
			}
			
			else if (e.getSource() == editCar) {
				
				new EditView();
				
				
			}
			
			if ((e.getSource() == edit ) || ( e.getSource() == editField  )) {
				
				carToEdit = editField.getText();
				
				editField.setText("");
				
				
			}
			
				 
			if (e.getSource() == newCarText) {
				
							  
			  String newName = newCarText.getText();
			  fleet.editName(carToEdit, newName);
			  newCarText.setText("");}
			 
			if (e.getSource() == newCarMiles) {
			  int newMiles = Integer.parseInt(newCarMiles.getText());
			  fleet.editMiles(carToEdit, newMiles);
			  newCarMiles.setText("");
			}
			if (e.getSource() == newCarFuel) {
			  int newFuel = Integer.parseInt(newCarFuel.getText());
			  fleet.editFuel(carToEdit, newFuel);
			  newCarFuel.setText("");
							  
				}
				
			
		
			if(e.getSource() == clickToLoad) {
				try {
					Load_Fleet load = new Load_Fleet(fleet);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if (e.getSource() == closeEditView) {
				editWidget.setDefaultCloseOperation();
				orderedMPGFleet.setText("Fleet by MPG:" + fleet.getSortedByMPG().toString());
				orderedFleet.setText("Fleet as entered:" + fleet.toString());
			}
			
			try {
			orderedMPGFleet.setText("Fleet by MPG:" + fleet.getSortedByMPG().toString());
			orderedFleet.setText("Fleet as entered:" + fleet.toString());
			bestMPG.setText("Best MPG:" + fleet.getBestMPG());
			highMiles.setText("Highest Mileage:" + fleet.getHighMiles());
			fleetAvg.setText("Fleet Avg:" + fleet.getFleetAverageMPG());
			}
			
			catch  (IndexOutOfBoundsException x) {
			
			    
				orderedMPGFleet.setText("Fleet by MPG:" );
				orderedFleet.setText("Fleet as entered:" );
				bestMPG.setText("Best MPG:");
				highMiles.setText("Highest Mileage:");
				fleetAvg.setText("Fleet Avg:");
			}
			
			carId.setText("");
			newMiles.setText("");
			newFuel.setText("");
			
			if(e.getSource() == clickToSave) {
				
					try {
						Save_Fleet save = new Save_Fleet(fleet);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
			
			
		}
		
		
		
		}

}
