package main;

import gui.MainFrame;
import model.Model;

public class App {

	public static void main(String[] args) {
		
		new App();

	}
	
	public App() {
		Model model = new Model(5);
		new MainFrame(model);
	}
}
