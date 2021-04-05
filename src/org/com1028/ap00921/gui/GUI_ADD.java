package org.com1028.ap00921.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.com1028.ap00921.classes.Album;
import org.com1028.ap00921.classes.Artist;
import org.com1028.ap00921.classes.Format;
import org.com1028.ap00921.classes.Genre;
import org.com1028.ap00921.classes.Length;
import org.com1028.ap00921.classes.Single;
import org.com1028.ap00921.db.DBFactory;
import org.com1028.ap00921.db.MusicDB;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "serial" })
public class GUI_ADD extends JFrame{

	private JPanel contentPane;
	
	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField textFieldYear;
	
	
	private JComboBox comboBoxFormat;
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxNoOfSongs;
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ADD frame = new GUI_ADD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_ADD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelDetails();
		
		panelButtons();
	}
	
	/**
	 * Initialize the buttons panel
	 */
	private void panelButtons() {
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(21, 523, 1114, 55);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GUI gui = new GUI();
				gui.setVisible(true);
				
			}
		});
		btnCancel.setBounds(973, 0, 141, 35);
		panelButtons.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getCellEditor() != null)
				{
				    table.getCellEditor().stopCellEditing();
				}
				writeDetails();
				dispose();
				GUI gui = new GUI();
				gui.setVisible(true);
			}
		});
		btnSave.setBounds(811, 0, 141, 35);
		panelButtons.add(btnSave);
	}
	
	/**
	 * Initialize the album details fields
	 */
	@SuppressWarnings({ "unchecked" })
	private void panelDetails() {
		JPanel panelDetails = new JPanel();
		panelDetails.setBounds(21, 21, 1114, 226);
		contentPane.add(panelDetails);
		GridBagLayout gbl_panelDetails = new GridBagLayout();
		gbl_panelDetails.columnWidths = new int[]{160, 949, 0};
		gbl_panelDetails.rowHeights = new int[]{32, 32, 32, 32, 32, 32, 0};
		gbl_panelDetails.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDetails.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDetails.setLayout(gbl_panelDetails);
		
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelDetails.add(lblTitle, gbc_lblTitle);
		
		textFieldTitle = new JTextField();
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.anchor = GridBagConstraints.NORTH;
		gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitle.gridx = 1;
		gbc_textFieldTitle.gridy = 0;
		panelDetails.add(textFieldTitle, gbc_textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblArtist = new JLabel("Artist");
		GridBagConstraints gbc_lblArtist = new GridBagConstraints();
		gbc_lblArtist.anchor = GridBagConstraints.EAST;
		gbc_lblArtist.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtist.gridx = 0;
		gbc_lblArtist.gridy = 1;
		panelDetails.add(lblArtist, gbc_lblArtist);
		
		textFieldArtist = new JTextField();
		GridBagConstraints gbc_textFieldArtist = new GridBagConstraints();
		gbc_textFieldArtist.anchor = GridBagConstraints.NORTH;
		gbc_textFieldArtist.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldArtist.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldArtist.gridx = 1;
		gbc_textFieldArtist.gridy = 1;
		panelDetails.add(textFieldArtist, gbc_textFieldArtist);
		textFieldArtist.setColumns(10);
		
		JLabel lblFormat = new JLabel("Format");
		GridBagConstraints gbc_lblFormat = new GridBagConstraints();
		gbc_lblFormat.anchor = GridBagConstraints.EAST;
		gbc_lblFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormat.gridx = 0;
		gbc_lblFormat.gridy = 2;
		panelDetails.add(lblFormat, gbc_lblFormat);
		
		comboBoxFormat = new JComboBox();
		comboBoxFormat.setModel(new DefaultComboBoxModel(Format.values()));
		GridBagConstraints gbc_comboBoxFormat = new GridBagConstraints();
		gbc_comboBoxFormat.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFormat.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxFormat.gridx = 1;
		gbc_comboBoxFormat.gridy = 2;
		panelDetails.add(comboBoxFormat, gbc_comboBoxFormat);
		
		JLabel lblYearOfRelease = new JLabel("Year of release");
		GridBagConstraints gbc_lblYearOfRelease = new GridBagConstraints();
		gbc_lblYearOfRelease.anchor = GridBagConstraints.EAST;
		gbc_lblYearOfRelease.insets = new Insets(0, 0, 5, 5);
		gbc_lblYearOfRelease.gridx = 0;
		gbc_lblYearOfRelease.gridy = 3;
		panelDetails.add(lblYearOfRelease, gbc_lblYearOfRelease);
		
		textFieldYear = new JTextField();
		GridBagConstraints gbc_textFieldYear = new GridBagConstraints();
		gbc_textFieldYear.anchor = GridBagConstraints.NORTH;
		gbc_textFieldYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldYear.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldYear.gridx = 1;
		gbc_textFieldYear.gridy = 3;
		panelDetails.add(textFieldYear, gbc_textFieldYear);
		textFieldYear.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.EAST;
		gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenre.gridx = 0;
		gbc_lblGenre.gridy = 4;
		panelDetails.add(lblGenre, gbc_lblGenre);
		
		comboBoxNoOfSongs = new JComboBox();
		comboBoxNoOfSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] string = new String[Integer.valueOf((String) comboBoxNoOfSongs.getSelectedItem())][3];
				for(int i = 0; i < Integer.valueOf((String) comboBoxNoOfSongs.getSelectedItem()); i++) {
						string[i][0] = null;
						string[i][1] = null;
						string[i][2] = null;
				}
				tablePanel(customTable(string));
			}
		});
		comboBoxNoOfSongs.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "17", "18", "19", "20"}));
		GridBagConstraints gbc_comboBoxNoOfSongs = new GridBagConstraints();
		gbc_comboBoxNoOfSongs.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxNoOfSongs.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNoOfSongs.gridx = 1;
		gbc_comboBoxNoOfSongs.gridy = 5;
		panelDetails.add(comboBoxNoOfSongs, gbc_comboBoxNoOfSongs);
		
		comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(new DefaultComboBoxModel(Genre.values()));
		GridBagConstraints gbc_comboBoxGenre = new GridBagConstraints();
		gbc_comboBoxGenre.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGenre.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxGenre.gridx = 1;
		gbc_comboBoxGenre.gridy = 4;
		panelDetails.add(comboBoxGenre, gbc_comboBoxGenre);
		
		JLabel lblNumberOfSongs = new JLabel("Number of songs");
		GridBagConstraints gbc_lblNumberOfSongs = new GridBagConstraints();
		gbc_lblNumberOfSongs.anchor = GridBagConstraints.EAST;
		gbc_lblNumberOfSongs.insets = new Insets(0, 0, 0, 5);
		gbc_lblNumberOfSongs.gridx = 0;
		gbc_lblNumberOfSongs.gridy = 5;
		panelDetails.add(lblNumberOfSongs, gbc_lblNumberOfSongs);
		
		
	}
	
	/**
	 * Initialize table panel with the number of rows
	 * selected by user to enter the songs
	 * 
	 * @param tableModel
	 */
	private void tablePanel(TableModel tableModel) {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 242, 1114, 263);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setModel(tableModel);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			scrollPane.setViewportView(table);
			
		}
	
	/**
	 * 
	 * @param string
	 * @return custom table model by user
	 */
	private TableModel customTable(String[][] string) {
		TableModel table = new DefaultTableModel(
				string,
				new String[] {"Title", "Minutes", "Seconds"}
				);
		
		return table;
	}
	
	/**
	 * Method of writing all the album details into the database
	 */
	private void writeDetails() {
		
		Album album = new Album();
		
		if(textFieldTitle.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter the title of the album");
		} else {
			album.setTitle(textFieldTitle.getText());
		}
		
		album.setGenre(Genre.valueOf(comboBoxGenre.getSelectedItem().toString()));
		
		if(textFieldArtist.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter the artist name");
		} else {
			album.setArtist(textFieldArtist.getText());
		}
		
		if(textFieldArtist.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter the year of release");
		} else if(Integer.valueOf(textFieldYear.getText()) < 1000 || Integer.valueOf(textFieldYear.getText()) > 9999) {
			JOptionPane.showMessageDialog(null, "Please enter a valid year of release");
		} else {
			album.setYear(Integer.valueOf(textFieldYear.getText()));
		}		
		
		album.setNumberOfSongs(Integer.valueOf((String) comboBoxNoOfSongs.getSelectedItem()));
		
		album.setFormat(Format.valueOf(comboBoxFormat.getSelectedItem().toString()));
		
		Artist artist = new Artist(textFieldArtist.getText());
		
		List<Single> songs = new ArrayList<Single>();
		Length length = new Length();
		
		for(int i = 0; i < Integer.valueOf((String) comboBoxNoOfSongs.getSelectedItem()); i++) {
			Single song = new Single();
			song.setTitle((String) table.getModel().getValueAt(i, 0));
			song.setGenre(Genre.valueOf(comboBoxGenre.getSelectedItem().toString()));
			song.setArtist(textFieldArtist.getText());
			song.setYear(Integer.valueOf(textFieldYear.getText()));
			song.setLength(length.calculateReverseLength(Integer.valueOf((String) table.getModel().getValueAt(i, 1)), Integer.valueOf((String) table.getModel().getValueAt(i, 2))));
			song.setAlbum(textFieldTitle.getText());
			
			songs.add(song);
		}
		
		MusicDB musicDB = null;
		try {			
			musicDB = DBFactory.getMusicDB();
			
			musicDB.writeAlbum(album, songs, artist);
			
			
		} catch (Exception e) {
			// catch any exceptions and log them`
			e.printStackTrace();
		}
	}
}
