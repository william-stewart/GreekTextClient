import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;


public class GreekGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final JTextPane textPane = new JTextPane();
	final int keyWidth;
	final int keyHeight;
	final int keyboardAnchorX;
	final int keyboardAnchorY;
	final int keyboardAnchorXRowTwo;
	final int keyboardAnchorYRowTwo;
	final int keyboardAnchorXRowThree;
	final int keyboardAnchorYRowThree;
	
	boolean capsOn = false;
	
	private JButton btnAlphaLow;
	private JButton btnBetaLow;
	private JButton btnGammaLow;
	private JButton btnDeltaLow;
	private JButton btnEpsilonLow;
	private JButton btnZetaLow;
	private JButton btnEtaLow;
	private JButton btnThetaLow;
	private JButton btnIotaLow;
	private JButton btnKappaLow;
	private JButton btnLambdaLow;
	private JButton btnMuLow;
	private JButton btnNuLow;
	private JButton btnXiLow;
	private JButton btnOmicronLow;
	private JButton btnPiLow;
	private JButton btnRhoLow;
	private JButton btnSigmaLow;
	private JButton btnTauLow;
	private JButton btnUpsilonLow;
	private JButton btnPhiLow;
	private JButton btnChiLow;
	private JButton btnPsiLow;
	private JButton btnOmegaLow;

	static int alpha = 0x03b1;
	static int beta = 0x03b2;
	static int gamma = 0x03b3;
	static int delta = 0x03b4;
	static int epsilon = 0x03b5;
	static int zeta = 0x03b6;
	static int eta = 0x03b7;
	static int theta = 0x03b8;
	static int iota = 0x03b9;
	static int kappa = 0x03ba;
	static int lambda = 0x03bb;
	static int mu = 0x03bc;
	static int nu = 0x03bd;
	static int xi = 0x03be;
	static int omicron = 0x03bf;
	static int pi = 0x03c0;
	static int rho = 0x03c1;
	static int sigma = 0x03c3;
	static int tau = 0x03c4;
	static int upsilon = 0x03c5;
	static int phi = 0x03c6;
	static int chi = 0x03c7;
	static int psi = 0x03c8;
	static int omega = 0x03c9;
	
	int[] alphabet = {alpha,beta,gamma,delta,epsilon,zeta,eta,theta,iota,kappa,lambda,mu,nu,xi,omicron,pi,rho,sigma,tau,upsilon,phi,chi,psi,omega};
	

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GreekGUI frame = new GreekGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Write to TextPane
	 */
	public void appendString(String str) throws BadLocationException{
		StyledDocument document = (StyledDocument) textPane.getDocument();
	     document.insertString(document.getLength(), str, null);
	}
	
	public void deleteChar() throws BadLocationException{
		StyledDocument document = (StyledDocument) textPane.getDocument();
		document.remove(document.getLength()-1,1);
	}
	
	public void resetButtonText(){
		btnAlphaLow.setText(hexConverter(alphabet[0]));
		btnBetaLow.setText(hexConverter(alphabet[1]));
		btnGammaLow.setText(hexConverter(alphabet[2]));
		btnDeltaLow.setText(hexConverter(alphabet[3]));
		btnEpsilonLow.setText(hexConverter(alphabet[4]));
		btnZetaLow.setText(hexConverter(alphabet[5]));
		btnEtaLow.setText(hexConverter(alphabet[6]));
		btnThetaLow.setText(hexConverter(alphabet[7]));
		btnIotaLow.setText(hexConverter(alphabet[8]));
		btnKappaLow.setText(hexConverter(alphabet[9]));
		btnLambdaLow.setText(hexConverter(alphabet[10]));
		btnMuLow.setText(hexConverter(alphabet[11]));
		btnNuLow.setText(hexConverter(alphabet[12]));
		btnXiLow.setText(hexConverter(alphabet[13]));
		btnOmicronLow.setText(hexConverter(alphabet[14]));
		btnPiLow.setText(hexConverter(alphabet[15]));
		btnRhoLow.setText(hexConverter(alphabet[16]));
		btnSigmaLow.setText(hexConverter(alphabet[17]));
		btnTauLow.setText(hexConverter(alphabet[18]));
		btnUpsilonLow.setText(hexConverter(alphabet[19]));
		btnPhiLow.setText(hexConverter(alphabet[20]));
		btnChiLow.setText(hexConverter(alphabet[21]));
		btnPsiLow.setText(hexConverter(alphabet[22]));
		btnOmegaLow.setText(hexConverter(alphabet[23]));
	}
	
	public void shiftCase(){
		if(!capsOn){
			for(int i=0;i<alphabet.length-1;i++){
				alphabet[i]-=0x0020;
			}
			capsOn=true;
		}else{
			for(int i=0;i<alphabet.length-1;i++){
				alphabet[i]+=0x0020;
			}
			capsOn=false;
		}
		resetButtonText();
	}
	
	public String hexConverter(int hexVal){
		return Character.toString((char)(Integer.parseInt(Integer.toHexString(hexVal),16)));
	}

	/**
	 * Create the frame.
	 */
	public GreekGUI() {
		this.keyboardAnchorX = 100;
		this.keyboardAnchorY = 300;
		this.keyWidth = 50;
		this.keyHeight = 50;
		this.keyboardAnchorXRowTwo = keyboardAnchorX-12;
		this.keyboardAnchorYRowTwo = keyboardAnchorY+50;
		this.keyboardAnchorXRowThree = keyboardAnchorX;
		this.keyboardAnchorYRowThree = keyboardAnchorY+100;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Greek Text Client");
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPopupMenu popupMenu = new JPopupMenu("Popup");
		popupMenu.setSize(181, 150);
		//popupMenu.setLocation(150, 273);
		popupMenu.add("example");
		addPopup(contentPane, popupMenu);
		
		//Top label
		JLabel lblTypeHere = new JLabel("Type here:");
		lblTypeHere.setBounds(12, 12, 74, 14);
		contentPane.add(lblTypeHere);
		
		//Text Pane
		textPane.setFont(new Font("Calibri", Font.PLAIN, 20));
		textPane.setContentType("UTF-8");
		textPane.setBounds(12, 30, 679, 235);
		contentPane.add(textPane);
		
		//Keyboard
		polytonicGreekKeyboard();
		
	}
	
	public void polytonicGreekKeyboard(){
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(100, 244, 200, 50);
		popupMenu.add("popup");
		contentPane.add(popupMenu);
		
		JMenuItem menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
			menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
			popupMenu.add(menuItem);
		
		JButton btnEndSigma = new JButton("\u03C2");
		btnEndSigma.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnEndSigma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				appendString("\u03C2");
				}catch(Exception e){}
			}
		});
		btnEndSigma.setBounds(keyboardAnchorX, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnEndSigma);
		
		btnEpsilonLow = new JButton("\u03B5");
		btnEpsilonLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnEpsilonLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03B5");
					}catch(Exception e){}
			}
		});
		btnEpsilonLow.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	try{
		    		popupMenu.show(btnEpsilonLow,0,-50);
		    	}
		    	catch(Exception e){}
		    }

		    @SuppressWarnings("deprecation")
			public void mouseExited(java.awt.event.MouseEvent evt) {
		    	popupMenu.hide();
		    }
		});
		btnEpsilonLow.setBounds(keyboardAnchorX+50, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnEpsilonLow);
		
		 btnRhoLow = new JButton("\u03C1");
		btnRhoLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnRhoLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03C1");
					}catch(Exception e){}
			}
		});
		btnRhoLow.setBounds(keyboardAnchorX+100, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnRhoLow);
		
		 btnTauLow = new JButton("\u03C4");
		btnTauLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03C4");
					}catch(Exception e){}
			}
		});
		btnTauLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnTauLow.setBounds(keyboardAnchorX+150, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnTauLow);
		
		 btnUpsilonLow = new JButton("\u03C5");
		btnUpsilonLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03C5");
					}catch(Exception e){}
			}
		});
		btnUpsilonLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnUpsilonLow.setBounds(keyboardAnchorX+200, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnUpsilonLow);
		
		 btnThetaLow = new JButton("\u03B8");
		btnThetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03B8");
					}catch(Exception e){}
			}
		});
		btnThetaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnThetaLow.setBounds(keyboardAnchorX+250, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnThetaLow);
		
		 btnIotaLow = new JButton("\u03B9");
		 btnIotaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03B9");
					}catch(Exception e){}
			}
		});
		 btnIotaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		 btnIotaLow.setBounds(keyboardAnchorX+300, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnIotaLow);
		
		 btnOmicronLow = new JButton("\u03BF");
		btnOmicronLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03BF");
					}catch(Exception e){}
			}
		});
		btnOmicronLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnOmicronLow.setBounds(keyboardAnchorX+350, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnOmicronLow);
		
		 btnPiLow = new JButton("\u03C0");
		btnPiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03C0");
					}catch(Exception e){}
			}
		});
		btnPiLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnPiLow.setBounds(keyboardAnchorX+400, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnPiLow);
		
		JButton btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnDel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
				deleteChar();
				}catch(Exception e){}
		}
		});
		btnDel.setBounds(keyboardAnchorX+450, keyboardAnchorY, keyWidth+30, keyHeight);
		contentPane.add(btnDel);
		
		btnAlphaLow = new JButton(hexConverter(alphabet[0]));
		btnAlphaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAlphaLow.setBounds(keyboardAnchorXRowTwo, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnAlphaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[0]));
					}catch(Exception e){}
			}
		});
		contentPane.add(btnAlphaLow);
		
		 btnSigmaLow = new JButton("\u03c3");
		btnSigmaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnSigmaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth(), keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnSigmaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03c3");
					}catch(Exception e){}
			}
		});contentPane.add(btnSigmaLow);
		
		 btnDeltaLow = new JButton(hexConverter(alphabet[3]));
		btnDeltaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnDeltaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*2, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnDeltaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[3]));
					}catch(Exception e){}
			}
		});contentPane.add(btnDeltaLow);
		
		 btnPhiLow = new JButton("\u03c6");
		btnPhiLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnPhiLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*3, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnPhiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03c6");
					}catch(Exception e){}
			}
		});contentPane.add(btnPhiLow);
		
		 btnGammaLow = new JButton(hexConverter(alphabet[2]));
		btnGammaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnGammaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*4, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnGammaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[2]));
					}catch(Exception e){}
			}
		});contentPane.add(btnGammaLow);
		
		 btnEtaLow = new JButton("\u03b7");
		btnEtaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnEtaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*5, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnEtaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03b7");
					}catch(Exception e){}
			}
		});contentPane.add(btnEtaLow);
		
		 btnXiLow = new JButton("\u03be");
		 btnXiLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		 btnXiLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*6, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		 btnXiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03be");
					}catch(Exception e){}
			}
		});contentPane.add(btnXiLow);
		
		 btnKappaLow = new JButton("\u03ba");
		btnKappaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnKappaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*7, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnKappaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03ba");
					}catch(Exception e){}
			}
		});contentPane.add(btnKappaLow);
		
		 btnLambdaLow = new JButton("\u03bb");
		btnLambdaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnLambdaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*8, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnLambdaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03bb");
					}catch(Exception e){}
			}
		});contentPane.add(btnLambdaLow);
		
		JButton btnCap = new JButton("CAP");
		btnCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shiftCase();
			}
		});
		btnCap.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnCap.setBounds(55, 400, keyWidth+45, keyHeight);
		contentPane.add(btnCap);
		
		 btnZetaLow = new JButton("\u03b6");
		btnZetaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnZetaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*1, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnZetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03b6");
					}catch(Exception e){}
			}
		});contentPane.add(btnZetaLow);
		
		 btnChiLow = new JButton("\u03c7");
		btnChiLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnChiLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*2, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnChiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03c7");
					}catch(Exception e){}
			}
		});contentPane.add(btnChiLow);
		
		 btnPsiLow = new JButton("\u03c8");
		btnPsiLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnPsiLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*3, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnPsiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03c8");
					}catch(Exception e){}
			}
		});contentPane.add(btnPsiLow);
		
		 btnOmegaLow = new JButton("\u03c9");
		btnOmegaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnOmegaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*4, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnOmegaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03c9");
					}catch(Exception e){}
			}
		});contentPane.add(btnOmegaLow);
		
		btnBetaLow = new JButton(hexConverter(alphabet[1]));
		btnBetaLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnBetaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*5, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnBetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[1]));
					}catch(Exception e){}
			}
		});contentPane.add(btnBetaLow);
		
		 btnNuLow = new JButton("\u03bd");
		btnNuLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnNuLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*6, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnNuLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03bd");
					}catch(Exception e){}
			}
		});contentPane.add(btnNuLow);
		
		 btnMuLow = new JButton("\u03bc");
		btnMuLow.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnMuLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*7, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnMuLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u03bc");
					}catch(Exception e){}
			}
		});contentPane.add(btnMuLow);
		
		JButton btnPeriod = new JButton("\u002e");
		btnPeriod.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnPeriod.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*8, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u002e");
					}catch(Exception e){}
			}
		});contentPane.add(btnPeriod);
		
		JButton btnQuestion = new JButton("\u003f");
		btnQuestion.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnQuestion.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*9, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u003f");
					}catch(Exception e){}
			}
		});contentPane.add(btnQuestion);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnReturn.setBounds(538, 350, keyWidth+63, keyHeight);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\n");
					}catch(Exception e){}
			}
		});contentPane.add(btnReturn);
JComboBox comboBox = new JComboBox();
comboBox.setModel(new DefaultComboBoxModel(new String[] {"DIA", "\u1FBD", "\u1FCD", "\u1FCE", "\u1FCF", "\u1FFE", "\u1FDD", "\u1FDE", "\u1FDF", "\u1FFD", "\u1FEF", "\u1FC0"}));
comboBox.setFont(new Font("Tahoma", Font.PLAIN, 26));
comboBox.setBounds(450, 461, 100, 28);
contentPane.add(comboBox);
JButton btnNewButton = new JButton("SPACE");
btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		try{
			appendString(" ");
			}catch(Exception e){}
	}
});
btnNewButton.setBounds(188, 450, 250, 50);
contentPane.add(btnNewButton);
JRadioButton rdbtnWithIotaSub = new JRadioButton("With iota sub");
rdbtnWithIotaSub.setFont(new Font("Calibri", Font.PLAIN, 18));
rdbtnWithIotaSub.setBounds(560, 457, 150, 23);
contentPane.add(rdbtnWithIotaSub);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}