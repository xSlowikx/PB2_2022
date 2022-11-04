package ar.unlam.edu.pb2;

import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Album {
	
	private TreeMap <String,Figurita> listaDeFiguritas;
	
	public Album (){
		
		this.listaDeFiguritas = new TreeMap<>();
	}
}
