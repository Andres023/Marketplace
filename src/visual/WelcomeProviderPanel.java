package visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import world.Service;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WelcomeProviderPanel extends JPanel implements ActionListener{

	private Controller ctrl;
	private Main main;
	
	private JButton logOutBtn;
	private JButton showSales;
	private JButton showTrasactionsByClient;
	private JTextField nameTxt;
	private JTextField costTxt;
	private JTextField originCityTxt;
	private JTextField destinationCityTxt;
	private JButton publish;
	
	private JRadioButton transportRadio;
	private JRadioButton hotelRadio;
	private JRadioButton foodRadio;
	private JScrollPane scroll;
	private JTextField since;
	private JTextField from;
	private JTextArea hisotryTxtArea;
	
	private String sales;
	private JLabel salesPeriodLbl;
	
	public WelcomeProviderPanel(Controller ctrl, Main main) {
		
		this.ctrl = ctrl;
		this.main = main;
		
		setSize(900, 600);
		setLayout(null);
		
		JLabel title = new JLabel("BIENVENIDO(A) SE\u00D1OR(A): ");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(62, 50, 683, 38);
		add(title);
		
		JLabel welcomelbl = new JLabel("\u00BFQu\u00E9 desea hacer hoy?");
		welcomelbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		welcomelbl.setBounds(62, 110, 217, 20);
		add(welcomelbl);
		
		JLabel publishServiceLbl = new JLabel("Publicar oferta");
		publishServiceLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		publishServiceLbl.setBounds(62, 147, 194, 33);
		add(publishServiceLbl);
		
		logOutBtn = new JButton("Cerrar sesi\u00F3n");
		logOutBtn.setBounds(672, 508, 138, 23);
		logOutBtn.addActionListener(this);
		add(logOutBtn);
		
		showSales = new JButton("Ventas globales");
		showSales.setBounds(465, 456, 138, 23);
		showSales.addActionListener(this);
		add(showSales);
		
		showTrasactionsByClient = new JButton("Ventas de un cliente");
		showTrasactionsByClient.setBounds(660, 456, 150, 23);
		showTrasactionsByClient.addActionListener(this);
		add(showTrasactionsByClient);
		
		JLabel serviceNameLbl = new JLabel("Nombre del servicio");
		serviceNameLbl.setBounds(62, 190, 138, 14);
		add(serviceNameLbl);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(193, 190, 229, 20);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel costLbl = new JLabel("Costo");
		costLbl.setBounds(62, 223, 46, 14);
		add(costLbl);
		
		costTxt = new JTextField();
		costTxt.setBounds(193, 220, 229, 20);
		add(costTxt);
		costTxt.setColumns(10);
		
		JLabel originCityLbl = new JLabel("Ciudad de Origen");
		originCityLbl.setBounds(62, 253, 127, 14);
		add(originCityLbl);
		
		originCityTxt = new JTextField();
		originCityTxt.setColumns(10);
		originCityTxt.setBounds(193, 250, 229, 20);
		add(originCityTxt);
		
		JLabel descriptionLbl = new JLabel("Descripci\u00F3n del paquete");
		descriptionLbl.setBounds(62, 289, 172, 14);
		add(descriptionLbl);
		
		JLabel destinationCityLbl = new JLabel("Ciudad de destino");
		destinationCityLbl.setBounds(62, 403, 127, 14);
		add(destinationCityLbl);
		
		destinationCityTxt = new JTextField();
		destinationCityTxt.setBounds(193, 400, 229, 20);
		add(destinationCityTxt);
		destinationCityTxt.setColumns(10);
		
		publish = new JButton("Publicar");
		publish.setBounds(62, 456, 89, 23);
		publish.addActionListener(this);
		add(publish);
		
		transportRadio = new JRadioButton("Transaporte");
		transportRadio.setBounds(62, 315, 109, 23);
		add(transportRadio);
		
		hotelRadio = new JRadioButton("Hotel");
		hotelRadio.setBounds(62, 341, 109, 23);
		add(hotelRadio);
		
		foodRadio = new JRadioButton("Alimento");
		foodRadio.setBounds(62, 367, 109, 23);
		add(foodRadio);
		
		hisotryTxtArea = new JTextArea();
		hisotryTxtArea.setEditable(false);
		hisotryTxtArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		hisotryTxtArea.setBounds(465, 99, 345, 346);
		add(hisotryTxtArea);
		
		scroll = new JScrollPane(hisotryTxtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(465, 120, 345, 295);
		this.add(scroll);
		
		JLabel lblNewLabel = new JLabel("Desde");
		lblNewLabel.setBounds(465, 431, 46, 14);
		add(lblNewLabel);
		
		since = new JTextField();
		since.setBounds(503, 427, 86, 20);
		add(since);
		since.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hasta");
		lblNewLabel_1.setBounds(599, 431, 46, 14);
		add(lblNewLabel_1);
		
		from = new JTextField();
		from.setBounds(634, 427, 86, 20);
		add(from);
		from.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("YYYY-MM-DD");
		lblNewLabel_2.setBounds(730, 431, 80, 14);
		add(lblNewLabel_2);
		
		salesPeriodLbl = new JLabel("");
		salesPeriodLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		salesPeriodLbl.setBounds(465, 88, 345, 31);
		add(salesPeriodLbl);


	}
	
	public void clearPanel() {
		nameTxt.setText("");
		costTxt.setText("");
		originCityTxt.setText("");
		destinationCityTxt.setText("");
		foodRadio.setSelected(false);
		hotelRadio.setSelected(false);
		transportRadio.setSelected(false);
		salesPeriodLbl.setText("");
		hisotryTxtArea.setText("");
		since.setText("");
		from.setText("");
	}
	
	public int findDescription(JRadioButton item) {
		if(item.isSelected()) {
			return 1; 
		}else {
			return 0;
		}
	}

	private void printSales(Date sinceDate, Date fromDate) {
		salesPeriodLbl.setText("Ventas en el periodo " + sinceDate + " / " + fromDate);
		String [] salesTmp = sales.split(",");
		String msg = "";
		String [] sale;

		for (int i = 0; i < salesTmp.length; i++) {
			sale = salesTmp[i].split("/");
			msg += "Venta no.00"+sale[0]+" "+sale[1]+" a nombre de: "+sale[3]+" "+sale[4]+"identificado con el número: "+sale[6]+" por un valor de: "+sale[2]+" el día: "+sale[6]+"\n\n";
		}

		hisotryTxtArea.setText(msg);
	}
	
	private void printSales() {
		String [] salesTmp = sales.split(",");
		String msg = "";
		String [] sale;
		String clientName = "";
		for (int i = 0; i < salesTmp.length; i++) {
			sale = salesTmp[i].split("/");
			msg += "Venta no.00"+sale[0]+" "+sale[1]+" a nombre de: "+sale[3]+" "+sale[4]+"identificado con el número: "+sale[6]+" por un valor de: "+sale[2]+" el día: "+sale[6]+"\n\n";
			clientName = sale[3];
		}
		
		salesPeriodLbl.setText("Ventas a nombre del cliente: " + clientName);
		hisotryTxtArea.setText(msg);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(publish.getText())) {
			System.out.println("publish");
			
			//Validate if the all JText are full
			if(nameTxt.getText().length() > 0 && costTxt.getText().length() > 0 && originCityTxt.getText().length() > 0
					&& destinationCityTxt.getText().length() > 0) {
				//Find the description of the service
				int trnsport = findDescription(transportRadio);
				int htel = findDescription(hotelRadio);
				int fod = findDescription(foodRadio);
				
				System.out.println(trnsport+" "+htel+" "+fod);
				
				//Check if at least one of the JRadioButton is selected
				if(trnsport == 0 && htel == 0 && fod == 0) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione al menos item de descripción", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
				}else{
					
					String name = nameTxt.getText();
					int cost = Integer.parseInt(costTxt.getText());
					String originCity = originCityTxt.getText();
					String destinationCity = destinationCityTxt.getText();
					
					//Create the service object
					Service service = new Service(name, cost, originCity, destinationCity, trnsport, htel, fod);
					
					ctrl.publishService(service);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}	
			
		}else if(e.getActionCommand().equalsIgnoreCase(showSales.getText())) {
			try {
				Date sinceDate = Date.valueOf(since.getText());
				Date fromDate = Date.valueOf(from.getText());

				sales = ctrl.searchSales(sinceDate, fromDate, null);
				//System.out.println(sales);
				if(sales.length() > 0) {
					printSales(sinceDate, fromDate);
				}else {
					JOptionPane.showMessageDialog(null, "No se han encontrado resultados para esta búsqueda", "Sin resultados", JOptionPane.ERROR_MESSAGE);
				}
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Rango de fechas no válidas", "Fechas inválidas", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getActionCommand().equalsIgnoreCase(showTrasactionsByClient.getText())) {
			
			String clientDoc = JOptionPane.showInputDialog("Ingrese el número de documento del cliente que desea buscar");
			
			if(clientDoc.length() > 0) {
				sales = ctrl.searchSales(null, null, clientDoc);
				if(sales.length() > 0) {
					printSales();
				}else {
					JOptionPane.showMessageDialog(null, "No se han encontrado resultados para esta búsqueda", "Sin resultados", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Debe llenarse este campo con algún valor para\npoder realizar la búsqueda", "Datos vacios", JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			clearPanel();
			main.providerWelcomeToMenu();
		}
		
	}

	
}
