package me.runescapejon.CrazyFeet.Commands.Util.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.spongepowered.api.entity.living.player.Player;

public class CrazyAutoFireFile {

	private final File auCrazyFirePlayers;
	public static ArrayList<String> cFPlayers;

	public CrazyAutoFireFile(File file) {

		auCrazyFirePlayers = file;
		cFPlayers = new ArrayList<>();

		if (!auCrazyFirePlayers.exists()) {
			try {
				auCrazyFirePlayers.createNewFile();
			} catch (IOException e) {
				System.out.println("CrazyFeet failed to create the AutoFirePlayers file!");
				e.printStackTrace();
			}
		}
	}

	public void add(Player player) {
		if (!cFPlayers.contains(player.getName())) {
			cFPlayers.add(player.getName());
		}
	}

	public void remove(Player player) {
		if (cFPlayers.contains(player.getName())) {
			cFPlayers.remove(player.getName());
		}
	}

	public ArrayList<String> getAutoFirePlayers() {
		return cFPlayers;
	}

	public void loadAutoFirePlayers() {
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(auCrazyFirePlayers));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String line;

			while ((line = reader.readLine()) != null) {
				if (cFPlayers.contains(line)) {
					cFPlayers.add(line);
				} else {
					cFPlayers.add(line);
				}
			}

			reader.close();
			input.close();

		} catch (Exception e) {
			System.out.println("CrazyFeet failed to load the AutoFire players!");
			e.printStackTrace();
		}
	}

	public void saveAutoFirePlayers() {
		try {
			FileWriter stream = new FileWriter(auCrazyFirePlayers);
			BufferedWriter out = new BufferedWriter(stream);

			for (String value : cFPlayers) {
				out.write(value);
				out.newLine();
			}

			out.close();
			stream.close();

		} catch (IOException e) {
			System.out.println("CrazyFeet failed to save AutoFire players!");
			e.printStackTrace();
		}

	}

	public boolean contains(String player) {
		return cFPlayers.contains(player);
	}
}
