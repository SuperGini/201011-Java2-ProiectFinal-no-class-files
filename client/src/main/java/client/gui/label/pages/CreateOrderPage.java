package client.gui.label.pages;

import client.gui.panel.TransparentPanel;
import lib.dto.autovehicle.PartDto;
import lib.dto.autovehicle.ServiceOrderDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderPage extends JLabel {

    private JPanel transparentPanel;
    private JList orderId;
    private JTextArea carProblemArea;
    private JTable partsArea;
    private JList partList;

    private JTable findPartArea;
    private JTextField addProblemField;
  //  private JTextField findPartField;
    private JButton addProblemButton;
    private JButton findPartButton;
    private JButton addPartToOrderButton;
    private JLabel genericLabel;
    private JLabel carProblemLabel;
    private JLabel orderPartsLable;
    private JButton findClientButton;
    private JButton findCarButton;
    private JButton createOrderButton;
    private JTextField findField;

    private DefaultListModel<ServiceOrderDto> listServiceOrderModel= new DefaultListModel<>();
    private DefaultListModel<PartDto> listPartModel = new DefaultListModel<>();
    private DefaultTableModel  tableModel;
    private JScrollPane scrollPane;

    private String [] label = {"Order:", "User:", "Client:", "Brand:", "Serial:"};
    private List<JLabel> genericLabels = new ArrayList<>();

    public CreateOrderPage(int x, int y, int width, int height) {
        tableModel = new DefaultTableModel();
        this.setBounds(x, y, width, height);
        initTransparentPanel();
        initCarProblemLabel();
        initListServiceOrder();
        intiCarProblemArea();
        initAddProblemField();
        initAddProblemButton();
        //initPartsArea();
       // tableData();


        //initFindPartField();
        findPartButton();
        initAddPartToOrderButton();
        initfindPartsArea();
        initGenerilLabels();
        initORderParsLable();
        initFindClientButton();
        initFindCarButton();
        initFindField();
        initPartList();
        initCreateOrder();


    }


    private void initTransparentPanel(){
        transparentPanel = new TransparentPanel(250,125,950,550);
        this.add(transparentPanel);
    }

    private void initCarProblemLabel(){
        carProblemLabel = new JLabel("Problems of the car:");
        carProblemLabel.setBounds(195,10,150,30);
        transparentPanel.add(carProblemLabel);
    }

    private void initORderParsLable(){
        orderPartsLable = new JLabel("Order parts:");
        orderPartsLable.setBounds(755,10,100,30);
        transparentPanel.add(orderPartsLable);
    }

    private void initListServiceOrder(){
        orderId = new JList();
        orderId.setModel(listServiceOrderModel);
        orderId.setBounds(5,10,100,530);
        transparentPanel.add(orderId);

    }

    private void intiCarProblemArea(){
        carProblemArea = new JTextArea();
        carProblemArea.setBounds(115,50,300,400);
        transparentPanel.add(carProblemArea);
    }

    private void initAddProblemField(){
        addProblemField = new JTextField();
        addProblemField.setBounds(115,460,300,30);
        transparentPanel.add(addProblemField);
    }

    private void initAddProblemButton(){
        addProblemButton = new JButton("add problem");
        addProblemButton.setBounds(115,500,300,30);
        transparentPanel.add(addProblemButton);
    }

    private void initPartList(){
        partList = new JList(listPartModel);
        partList.setBounds(645,50,300,350);
        transparentPanel.add(partList);
    }





//    private void initPartsArea(){
//        partsArea = new JTable(tableModel);
//        scrollPane = new JScrollPane(partsArea);
//        partsArea.setBounds(645,50,300,350);
//        transparentPanel.add(partsArea);
//        partsArea.setRowHeight(20);
////        partsArea.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15 ));
////        partsArea.setFont(new Font("Segoe UI", Font.BOLD, 12));
////        partsArea.getTableHeader().setOpaque(false);
////        partsArea.getTableHeader().setBackground(new Color(32,136,203));
////        partsArea.getTableHeader().setForeground(new Color(255,255,255));
////        partsArea.setShowVerticalLines(false);
////        partsArea.setSelectionBackground(new Color (232,57,95));





 //   }

        //todo: de vazut daca am timp sa fa cut tabel. Momentan am un bug la vizualizare si numerge
//    private void tableData(){
//        List<PartDto> partsDtos = new ArrayList<>();
//       // tableModel.setRowCount(0);
//
//        String [] columns = {"id", "part name", "count", "price"};
//
//
//        tableModel.setColumnIdentifiers(columns);
//
//
//
//
//        Object [] row = new Object [4];
//
//        for(PartDto partDto : partsDtos){
//            row[0] = partDto.getId();
//            row[1] = partDto.getPartName();
//            row[2] = partDto.getCount();
//            row[3] = partDto.getPrice();
//            tableModel.addRow(row);
//
//        }
//    }



    private void initfindPartsArea(){
        findPartArea = new JTable();
        findPartArea.setBounds(645,410,300,40);
        transparentPanel.add(findPartArea);
    }

//    private void initFindPartField(){
//        findPartField = new JTextField();
//        findPartField.setBounds(645,460,300,30);
//        transparentPanel.add(findPartField);
//    }



    private void initAddPartToOrderButton(){
        addPartToOrderButton =new JButton("add part to order");
        addPartToOrderButton.setBounds(645,500,300,30); //430,500,200,30
        transparentPanel.add(addPartToOrderButton);
    }

    private void initGenerilLabels(){
        for( int i = 0; i < 5; i++){
            genericLabel = new JLabel(label[i]);
            genericLabel.setBounds(420,50 + (i*30), 50,20);
            genericLabels.add(genericLabel);
            transparentPanel.add(genericLabel);
        }
    }

    private void initFindField(){
        findField = new JTextField();
        findField.setBounds(430,340,200,30);
        transparentPanel.add(findField);
    }

    private void initFindClientButton(){
        findClientButton = new JButton("find client");
        findClientButton.setBounds(430,380,200,30);
        transparentPanel.add(findClientButton);
    }

    private void initFindCarButton(){
        findCarButton = new JButton("find car serial");
        findCarButton.setBounds(430,420,200,30);
        transparentPanel.add(findCarButton);
    }

    private void findPartButton(){
        findPartButton = new JButton("find part");
        findPartButton.setBounds(430,460,200,30);
        transparentPanel.add(findPartButton);
    }

    private void initCreateOrder(){
        createOrderButton = new JButton("create order");
        createOrderButton.setBounds(430,500,200,30);
        transparentPanel.add(createOrderButton);
    }






}