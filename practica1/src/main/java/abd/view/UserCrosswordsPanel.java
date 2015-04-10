package abd.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import abd.controller.Controller;
import abd.model.Crucigrama;
import abd.model.Usuario;
import abd.observer.UserObserver;

public class UserCrosswordsPanel extends JTabbedPane implements UserObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controller cntr;
	private JPanel p_tab1;
	private JPanel p_tab2;
	private JPanel p_tab3;
	private JPanel p_wrapper1;
	private DefaultTableModel tbm;
	private JTable t_crosswords;
	private JButton b_abrir;
	private JButton b_buscar;
	private JScrollPane scroll;

	private ArrayList<Crucigrama> userCrosswords;

	public UserCrosswordsPanel(final Controller cntr) {
		this.cntr = cntr;
		this.userCrosswords = new ArrayList<Crucigrama>();

		this.setBorder(BorderFactory.createRaisedBevelBorder());
		p_tab1 = new JPanel(new BorderLayout());
		p_tab2 = new JPanel(new BorderLayout());
		p_tab3 = new JPanel(new BorderLayout());

		// --------------Tab 1---------------
		p_wrapper1 = new JPanel();

		tbm = new DefaultTableModel(new String[] { "Titulo", "Fecha" }, 10);
		t_crosswords = new JTable(tbm) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll = new JScrollPane(t_crosswords);
		scroll.setViewportView(t_crosswords);

		t_crosswords.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int fila = t_crosswords.rowAtPoint(e.getPoint());
				int columna = t_crosswords.columnAtPoint(e.getPoint());
				if ((fila > -1) && (columna > -1))
					System.out.println(tbm.getValueAt(fila, columna));// if
																		// !null...
			}
		});

		b_abrir = new JButton("Abrir crucigrama");
		b_abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		b_buscar = new JButton("Buscar crucigrama");
		b_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		p_wrapper1.add(b_abrir);
		p_wrapper1.add(b_buscar);

		p_tab1.add(scroll, BorderLayout.CENTER);
		p_tab1.add(p_wrapper1, BorderLayout.SOUTH);
		// --------------Tab 1---------------

		this.addTab("Crucigramas", p_tab1);
		this.addTab("Amigos", p_tab2);
		this.addTab("Peticiones de ayuda", p_tab3);
		
		this.cntr.addUserObserver(this);
	}

	@Override
	public void onUserAccessAccept() {
		// TODO Auto-generated method stub
		loadRows();
	}

	private void loadRows() {
		// TODO Auto-generated method stub
		Usuario u = this.cntr.getCurrentUser();
		this.userCrosswords = this.cntr.getUserCrosswords(u.getNombre());
		for (Crucigrama c : this.userCrosswords) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(c.getTitulo());
			rowData.add(c.getFecha());
			this.tbm.addRow(rowData);
		}
	}
	
	@Override
	public void onUserAccessRefused() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCurrentUserSetting(Usuario u) {
		// TODO Auto-generated method stub
		this.cntr.setCurrentUser(u);
	}

}
