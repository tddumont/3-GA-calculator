import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import java.util.PriorityQueue;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.Stack;
import java.util.EmptyStackException;
import java.lang.Math;

public class Calculator extends Application implements EventHandler<ActionEvent>{
	
	Stack<Double> opStack;
	
	String arg;
	
	Text display;
	
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bDiv, bSub, bMul, bC, bEnt, bDec, bLog;
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception{
		
		String goldButtonStyle = "-fx-background-color: rgba(230, 191, 0, 255); -fx-border-color: grey; -fx-font-size:20;";
		String purpleButtonStyle = "-fx-background-color: rgba(149, 128, 255, 255); -fx-border-color: grey; -fx-font-size:25;";
		String displayStyle = "-fx-text-fill: rgba(255, 255, 255, 255); -fx-border-color: grey; -fx-font-size:20;";
		
		
		arg = new String("");
		opStack = new Stack<Double>();
		
		double bWidth = 150;
		double bHeight = 150;
		
		VBox root = new VBox();
		HBox row0 = new HBox();
		HBox row1 = new HBox();
		HBox row2 = new HBox();
		HBox row3 = new HBox();
		HBox row4 = new HBox();
		
		stage.setTitle("Javafx calculator");
	
		Scene scene = new Scene(root, 750, 700, Color.BLACK);
		row0.setStyle("-fx-background-color: rgba(150,150,150,255);");
		row1.setStyle("-fx-background-color: rgba(50,50,50,255);");
		row2.setStyle("-fx-background-color: rgba(50,50,50,255);");
		row3.setStyle("-fx-background-color: rgba(50,50,50,255);");
		stage.setScene(scene);
		
		display = new Text();
		display.setWrappingWidth(600);
		display.setText("This calculator uses reverse Polish notation. Enter the first operand, press \"Enter\", enter the second operand, press \"Enter\", then press the button of the operation for result. For the log operator, the first operand is the base.");
		
		display.setStyle(displayStyle);
		
		//operand buttons
		b0 = new Button("0");
		b0.setMinSize(bWidth, bHeight);
		b0.setMaxSize(bWidth, bHeight);
		b0.setOnAction(this);
		b0.setStyle(goldButtonStyle);
		
		b1 = new Button("1");
		b1.setMinSize(bWidth, bHeight);
		b1.setMaxSize(bWidth, bHeight);
		b1.setOnAction(this);
		b1.setStyle(goldButtonStyle);
		
		b2 = new Button("2");
		b2.setMinSize(bWidth, bHeight);
		b2.setMaxSize(bWidth, bHeight);
		b2.setOnAction(this);
		b2.setStyle(goldButtonStyle);
		
		b3 = new Button("3");
		b3.setMinSize(bWidth, bHeight);
		b3.setMaxSize(bWidth, bHeight);
		b3.setOnAction(this);
		b3.setStyle(goldButtonStyle);
		
		b4 = new Button("4");
		b4.setMinSize(bWidth, bHeight);
		b4.setMaxSize(bWidth, bHeight);
		b4.setMaxSize(bWidth, bHeight);
		b4.setOnAction(this);
		b4.setStyle(goldButtonStyle);
		
		b5 = new Button("5");
		b5.setMinSize(bWidth, bHeight);
		b5.setMaxSize(bWidth, bHeight);
		b5.setOnAction(this);
		b5.setStyle(goldButtonStyle);
		
		b6 = new Button("6");
		b6.setMinSize(bWidth, bHeight);
		b6.setMaxSize(bWidth, bHeight);
		b6.setOnAction(this);
		b6.setStyle(goldButtonStyle);
		
		b7 = new Button("7");
		b7.setMinSize(bWidth, bHeight);
		b7.setMaxSize(bWidth, bHeight);
		b7.setOnAction(this);
		b7.setStyle(goldButtonStyle);
		
		b8 = new Button("8");
		b8.setMinSize(bWidth, bHeight);
		b8.setMaxSize(bWidth, bHeight);
		b8.setOnAction(this);
		b8.setStyle(goldButtonStyle);
		
		b9 = new Button("9");
		b9.setMinSize(bWidth, bHeight);
		b9.setMaxSize(bWidth, bHeight);
		b9.setOnAction(this);
		b9.setStyle(goldButtonStyle);
		
		bDec = new Button(".");
		bDec.setOnAction(this);
		bDec.setMinSize(bWidth, bHeight);
		bDec.setMaxSize(bWidth, bHeight);
		bDec.setStyle(purpleButtonStyle);
		
		//control buttons
		bC = new Button("Clear");
		bC.setOnAction(this);
		bC.setMinSize(bWidth, 100);
		bC.setMaxSize(bWidth, 100);
		bC.setStyle(purpleButtonStyle);
		
		bEnt = new Button("Enter");
		bEnt.setOnAction(this);
		bEnt.setMinSize(bWidth, bHeight);
		bEnt.setMaxSize(bWidth, bHeight);
		bEnt.setStyle(purpleButtonStyle);
		
		
		//operator buttons
		bAdd = new Button("+");
		bAdd.setOnAction(this);
		bAdd.setMinSize(bWidth, bHeight);
		bAdd.setMaxSize(bWidth, bHeight);
		bAdd.setStyle(purpleButtonStyle);
		
		bLog = new Button("logA(B)");
		bLog.setOnAction(this);
		bLog.setMinSize(bWidth, bHeight);
		bLog.setMaxSize(bWidth, bHeight);
		bLog.setStyle(purpleButtonStyle);
		
		bDiv = new Button("/");
		bDiv.setOnAction(this);
		bDiv.setMinSize(bWidth, bHeight);
		bDiv.setMaxSize(bWidth, bHeight);
		bDiv.setStyle(purpleButtonStyle);
		
		
		bSub = new Button("-");
		bSub.setOnAction(this);
		bSub.setMinSize(bWidth, bHeight);
		bSub.setMaxSize(bWidth, bHeight);
		bSub.setStyle(purpleButtonStyle);
		
		
		bMul = new Button("*");
		bMul.setMinSize(bWidth, bHeight);
		bMul.setMaxSize(bWidth, bHeight);
		bMul.setOnAction(this);
		bMul.setStyle(purpleButtonStyle);
		
		
		row0.getChildren().addAll(bC, display);
		row1.getChildren().addAll(b7, b8, b9, bMul);
		row2.getChildren().addAll(b4, b5, b6, bSub);
		row3.getChildren().addAll(b1, b2, b3, bAdd);
		row4.getChildren().addAll(bEnt, b0, bDec, bDiv, bLog);
		root.getChildren().addAll(row0, row1, row2, row3, row4);
		stage.show();
	}
	
	public void handle(ActionEvent event) {
		
		if (event.getSource() == bAdd){
			operator("+");
		}
		
		else if (event.getSource() == bDiv){
			operator("/");
		}
		
		else if (event.getSource() == bMul){
			operator("*");
		}
		
		else if (event.getSource() == bSub){
			operator("-");
		}
		
		else if (event.getSource() == bC){
			clear();
		}
		
		else if (event.getSource() == bLog) {
			operator("log");
		}
		
		else if (event.getSource() == bEnt){
			enter();
		}
		
		else {	
			arg = arg + ((Button) event.getSource()).getText();
			display.setText(arg);
		}

	}
	
	public void enter() {
		if (arg.equals("")) {
			error("No value to enter.");
		}
		else {
			//convert arg string to double and push to heap
			
			try {
				opStack.add(Double.parseDouble(arg));
				arg = "";
				display.setText(arg);
			}
			
			catch (NumberFormatException e){
				error("Invalid input. Only valid double values are accepted.");
			}
	
		}
	}
	
	public void clear() {
		//reset arg string to empty
		arg = "";
		//clear display
		display.setText("");
		//reset stack
		opStack = new Stack<Double>();
	}
	
	public void operator(String operator) {
		// pop two operands
		
		try {
			Double op1 = opStack.pop();
			Double op2 = opStack.pop();
			Double result = null;
			
			if (operator.equals("+")){
				result = op2 + op1;
				display.setText(op2 + operator + op1 + " = " + result);
				opStack.push(result);
			}
			else if (operator.equals("-")){
				result = op2 - op1;
				display.setText(op2 + operator + op1 + " = " + result);
				opStack.push(result);
			}
			else if (operator.equals("*")){
				result = op2 * op1;
				display.setText(op2 + operator + op1 + " = " + result);
				opStack.push(result);
			}
			
			else if (operator.equals("log")){
				result = Math.log(op1) / Math.log(op2);
				display.setText(operator + op2 + "(" + op1 + ") = "  + result);
				opStack.push(result);
			}
			
			else if (operator.equals("/")){
				if (op1 == 0) {
					error("Don't divide by zero, please and thank you.");
				}
				else {
					result = op2 / op1;
					display.setText(op2 + operator + op1 + " = " + result);
					opStack.push(result);
				}
			}
		}
		
		catch (EmptyStackException e) {
			error("Not enough operands. Be sure to enter both operands before using an operator. When entering an operand, enter the value using the numerical buttons and then press \"Enter\".");
		}
		
	}
	
	public void error(String message) {
		display.setText("Error: " + message);
	}
}
