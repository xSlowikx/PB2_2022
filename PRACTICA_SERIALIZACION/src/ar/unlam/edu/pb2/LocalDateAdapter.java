package ar.unlam.edu.pb2;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateAdapter extends TypeAdapter<LocalDate>{

	public LocalDateAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocalDate read(JsonReader arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(JsonWriter arg0, LocalDate arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}


}
