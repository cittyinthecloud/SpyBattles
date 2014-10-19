package io.github.famous1622.spybattles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	public void start() {
		Path path = Paths.get("ak47.obj");
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		 FileReader fr = null;
		try {
			fr = new FileReader(path.toString());
		} catch (FileNotFoundException e) {
			System.out.println("failed to load model");
		}
		 BufferedReader br = new BufferedReader(fr);
		 new Object3D(br,true);
		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			
			Display.update();
		}
		
		Display.destroy();
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.start();

	}

}
