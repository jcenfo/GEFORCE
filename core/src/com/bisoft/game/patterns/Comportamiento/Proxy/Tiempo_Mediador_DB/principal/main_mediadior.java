package com.bisoft.game.patterns.Comportamiento.Proxy.Tiempo_Mediador_DB.principal;

import com.bisoft.game.patterns.Comportamiento.Proxy.Stopwatch;

import java.io.*;

public class main_mediadior {
	public static Stopwatch stopwatch = new Stopwatch();

	public static void main(String[] args) throws IOException {
		gestor_mediadores gm = new gestor_mediadores();

		gm.record_Tiempo();

	}
}

