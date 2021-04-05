package org.com1028.ap00921.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.com1028.ap00921.classes.Album;
import org.com1028.ap00921.classes.Artist;
import org.com1028.ap00921.classes.Length;
import org.com1028.ap00921.classes.Single;
import org.com1028.ap00921.db.DBFactory;
import org.com1028.ap00921.db.MusicDB;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;

	private JTable table;
	private JTextField textField;

	//length of then collection
	private String length = "";
	//no of elements displayed and the nature of them
	private String elements = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		scrollPanel(songsTable());

		detailsPanel();

		buttonsPanel();

		topPanel();
	}

	/**
	 * Initialize the buttons panel
	 */
	private void buttonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 0, 139, 679);
		getContentPane().add(buttonsPanel);
		GridBagLayout gbl_buttonsPanel = new GridBagLayout();
		gbl_buttonsPanel.columnWidths = new int[] { 140, 0 };
		gbl_buttonsPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_buttonsPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_buttonsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		buttonsPanel.setLayout(gbl_buttonsPanel);

		JButton btnAlbums = new JButton("Albums");
		btnAlbums.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPanel(albumsTable());
				detailsPanel();
			}
		});
		GridBagConstraints gbc_btnAlbums = new GridBagConstraints();
		gbc_btnAlbums.insets = new Insets(0, 0, 5, 0);
		gbc_btnAlbums.fill = GridBagConstraints.BOTH;
		gbc_btnAlbums.gridx = 0;
		gbc_btnAlbums.gridy = 4;
		buttonsPanel.add(btnAlbums, gbc_btnAlbums);

		JButton btnArtists = new JButton("Artists");
		btnArtists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPanel(artistsTable());
				detailsPanel();
			}
		});
		GridBagConstraints gbc_btnArtists = new GridBagConstraints();
		gbc_btnArtists.insets = new Insets(0, 0, 5, 0);
		gbc_btnArtists.fill = GridBagConstraints.BOTH;
		gbc_btnArtists.gridx = 0;
		gbc_btnArtists.gridy = 6;
		buttonsPanel.add(btnArtists, gbc_btnArtists);

		JButton btnSongs = new JButton("Songs");
		btnSongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPanel(songsTable());
				detailsPanel();
			}
		});
		GridBagConstraints gbc_btnSongs = new GridBagConstraints();
		gbc_btnSongs.insets = new Insets(0, 0, 5, 0);
		gbc_btnSongs.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSongs.gridx = 0;
		gbc_btnSongs.gridy = 8;
		buttonsPanel.add(btnSongs, gbc_btnSongs);

		JButton btnAddAlbum = new JButton("Add album");
		btnAddAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GUI_ADD add = new GUI_ADD();
				add.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddAlbum = new GridBagConstraints();
		gbc_btnAddAlbum.fill = GridBagConstraints.BOTH;
		gbc_btnAddAlbum.gridx = 0;
		gbc_btnAddAlbum.gridy = 10;
		buttonsPanel.add(btnAddAlbum, gbc_btnAddAlbum);
	}

	/**
	 * Initialize the table panel
	 * 
	 * @param tm for different view
	 */
	private void scrollPanel(TableModel tm) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 109, 984, 570);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tm);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

	}

	/**
	 * Initialize the top panel
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void topPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBounds(141, 0, 984, 57);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(495, 7, 306, 35);
		topPanel.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(822, 7, 141, 35);
		topPanel.add(btnSearch);

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "date added", "alphabetical" }));
		comboBox.setBounds(103, 8, 157, 32);
		topPanel.add(comboBox);

		JLabel lblSortBy = new JLabel("Sort by:");
		lblSortBy.setBounds(21, 11, 92, 26);
		topPanel.add(lblSortBy);
	}

	/**
	 * Initialize the details panel
	 */
	private void detailsPanel() {
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(141, 57, 984, 51);
		getContentPane().add(detailsPanel);
		detailsPanel.setLayout(null);

		JLabel lblLengthlabel = new JLabel();
		lblLengthlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLengthlabel.setBounds(714, 21, 113, 26);
		detailsPanel.add(lblLengthlabel);
		lblLengthlabel.setText(length);

		JLabel lblXElements = new JLabel();
		lblXElements.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXElements.setBounds(863, 21, 100, 26);
		detailsPanel.add(lblXElements);
		lblXElements.setText(elements);
	}

	/**
	 * 
	 * @return table model for songs view
	 */
	private TableModel songsTable() {
		TableModel table = new DefaultTableModel(displaySongs(), new String[] { "Title", "Album", "Length" });

		return table;
	}

	/**
	 * Method to create a 2D String to display the songs details
	 * 
	 * @return 2D String with songs details
	 */
	private String[][] displaySongs() {
		MusicDB musicDB = null;
		String[][] str = null;
		try {

			Length totalLength = new Length();

			int tL = 0;

			musicDB = DBFactory.getMusicDB();

			List<Single> songs = musicDB.getSongs();

			String[][] string = new String[songs.size()][3];

			for (int i = 0; i < songs.size(); i++) {

				int length = songs.get(i).getLength();
				tL += length;

				string[i][0] = songs.get(i).getTitle();
				string[i][1] = songs.get(i).getAlbum();
				Length lengthSong = new Length();
				lengthSong.calculateLength(length);
				string[i][2] = lengthSong.toStringSingle();
			}

			totalLength.calculateLength(tL);

			elements = Integer.toString(songs.size()) + " songs";

			length = totalLength.toStringList();

			str = string;

		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 * @return table model for albums view
	 */
	private TableModel albumsTable() {
		TableModel table = new DefaultTableModel(displayAlbums(),
				new String[] { "Title", "Artist", "Number of songs" });

		return table;
	}

	/**
	 * Method to create a 2D String to display the albums details
	 * 
	 * @return 2D String with albums details
	 */
	private String[][] displayAlbums() {
		MusicDB musicDB = null;
		String[][] str = null;
		try {
			musicDB = DBFactory.getMusicDB();

			List<Album> albums = musicDB.getAlbums();

			String[][] string = new String[albums.size()][3];

			for (int i = 0; i < albums.size(); i++) {
				string[i][0] = albums.get(i).getTitle();
				string[i][1] = albums.get(i).getArtist();
				string[i][2] = Integer.toString(albums.get(i).getNumberOfSongs());
			}

			elements = Integer.toString(albums.size()) + " albums";

			length = "";

			str = string;

		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 * @return table model for artists view
	 */
	private TableModel artistsTable() {
		TableModel table = new DefaultTableModel(displayArtists(), new String[] { "ID", "Name", "" });

		return table;
	}

	/**
	 * Method to create a 2D String to display the artists details
	 * 
	 * @return 2D String with artists details
	 */
	private String[][] displayArtists() {
		MusicDB musicDB = null;
		String[][] str = null;
		try {
			musicDB = DBFactory.getMusicDB();

			List<Artist> artists = musicDB.getArtists();

			String[][] string = new String[artists.size()][3];

			for (int i = 0; i < artists.size(); i++) {
				string[i][0] = String.valueOf(artists.get(i).getId());
				string[i][1] = artists.get(i).getName();
				string[i][2] = "";
			}

			elements = Integer.toString(artists.size()) + " artists";

			length = "";

			str = string;

		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		}
		return str;
	}

}
