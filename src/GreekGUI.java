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
	JRadioButton rdbtnWithIotaSub;
	final int keyWidth;
	final int keyHeight;
	final int keyboardAnchorX;
	final int keyboardAnchorY;
	final int keyboardAnchorXRowTwo;
	final int keyboardAnchorYRowTwo;
	final int keyboardAnchorXRowThree;
	final int keyboardAnchorYRowThree;
	
	boolean capsOn = false;
	//boolean commonDiacritic = false;
	//boolean acuteOrGrave = false;
	
	private String currentDiacritic = "nd";
	
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
	
	static int alphaSmooth = 0x1f00;
	
	int[] alphabet = {alpha,beta,gamma,delta,epsilon,zeta,eta,theta,iota,kappa,lambda,mu,nu,xi,omicron,pi,rho,sigma,tau,upsilon,phi,chi,psi,omega};
	

	/**
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
	
	public void capCommonDiacritic(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]-=0x0020;
				}else{
					alphabet[i]+=0x0008;
				}
			}
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]+=0x0020;
				}else{
					alphabet[i]-=0x0008;
				}
			}
			capsOn=false;
		}
	}
	
	public void capAcute(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]-=0x0020;
				}
			}
			alphabet[0] = 0x1fbb;
			alphabet[4] =  0x1fc9;
			alphabet[6] = 0x1fcb;
			alphabet[8] = 0x1fdb;
			alphabet[14] = 0x1ff9;
			alphabet[19] = 0x1feb;
			alphabet[23] = 0x1ffb;
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]+=0x0020;
				}
			}
			alphabet[0] = 0x1f71;
			alphabet[4] =  0x1f73;
			alphabet[6] = 0x1f75;
			alphabet[8] = 0x1f77;
			alphabet[14] = 0x1f79;
			alphabet[19] = 0x1f7b;
			alphabet[23] = 0x1f7d;
			capsOn=false;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb4;
				alphabet[6]=0x1fc4;
				alphabet[23]=0x1ff4;
			}
				
			
		}
	}
	
	public void capGrave(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]-=0x0020;
				}
			}
			alphabet[0] = 0x1fba;
			alphabet[4] =  0x1fc8;
			alphabet[6] = 0x1fca;
			alphabet[8] = 0x1fda;
			alphabet[14] = 0x1ff8;
			alphabet[19] = 0x1fea;
			alphabet[23] = 0x1ffa;
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 4 && i != 6 && i != 8 && i != 14 && i != 19 && i != 23){
					alphabet[i]+=0x0020;
				}
			}
			alphabet[0] = 0x1f70;
			alphabet[4] =  0x1f72;
			alphabet[6] = 0x1f74;
			alphabet[8] = 0x1f76;
			alphabet[14] = 0x1f78;
			alphabet[19] = 0x1f7a;
			alphabet[23] = 0x1f7c;
			capsOn=false;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb2;
				alphabet[6]=0x1fc2;
				alphabet[23]=0x1ff2;
			}
		}
	}
	
	public void capCircumflex(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0 && i != 4 && i!= 6 && i != 8 && i != 19 && i != 23){
					alphabet[i]-=0x0020;
				}
			}
			alphabet[0] = 0x0391;
			alphabet[6] =  0x0397;
			alphabet[8] = 0x0399;
			alphabet[19] = 0x03a5;
			alphabet[23] = 0x03a9;
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 4 && i != 8 && i != 19 && i != 23){
					alphabet[i]+=0x0020;
				}
			}
			alphabet[0] = 0x1fb6;
			alphabet[6] =  0x1fc6;
			alphabet[8] = 0x1fd6;
			alphabet[19] = 0x1fe6;
			alphabet[23] = 0x1ff6;
			capsOn=false;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb7;
				alphabet[6]=0x1fc7;
				alphabet[23]=0x1ff7;
			}
		}
	}
	
	public void capBreve(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0  && i != 8 && i != 19){
					alphabet[i]-=0x0020;
				}
			}
			alphabet[0] = 0x1fb8;
			alphabet[8] = 0x1fd8;
			alphabet[19] = 0x1fe8;
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 8 && i != 19){
					alphabet[i]+=0x0020;
				}
			}
			alphabet[0] = 0x1fb0;
			alphabet[8] = 0x1fd0;
			alphabet[19] = 0x1fe0;
			capsOn=false;
		}
	}
	
	public void capMacron(){
		if(!capsOn){
			for(int i=0;i<alphabet.length;i++){
				//Normal capitalize for consanants
				if(i != 0  && i != 8 && i != 19){
					alphabet[i]-=0x0020;
				}
			}
			alphabet[0] = 0x1fb9;
			alphabet[8] = 0x1fd9;
			alphabet[19] = 0x1fe9;
			capsOn=true;
		}else{//return to lowercase
			for(int i=0;i<alphabet.length;i++){
				if(i != 0 && i != 8 && i != 19){
					alphabet[i]+=0x0020;
				}
			}
			alphabet[0] = 0x1fb1;
			alphabet[8] = 0x1fd1;
			alphabet[19] = 0x1fe1;
			capsOn=false;
		}
	}
	
	public void shiftCase(){
		//When no diacritic is selected
		if(currentDiacritic.equals("nd")){
			//With no iota subscript
			if(!rdbtnWithIotaSub.isSelected()){
				if(!capsOn){//capitalize all letters
					for(int i=0;i<alphabet.length;i++){
						alphabet[i]-=0x0020;
						alphabet[16]=0x03a1;
					}
					capsOn=true;
				}else{//return to lower case
					for(int i=0;i<alphabet.length;i++){
						alphabet[i]+=0x0020;
						alphabet[16]=0x03c1;
					}
					capsOn=false;
				}
			}else{//with iota subscript
				if(!capsOn){//capitalize all letters
					for(int i=0;i<alphabet.length;i++){
						alphabet[i]-=0x0020;
					}
					alphabet[0]=0x1fbc;
					alphabet[6]=0x1fcc;
					alphabet[23]=0x1ffc;
					capsOn=true;
				}else{//return to lower case
					for(int i=0;i<alphabet.length;i++){
						alphabet[i]+=0x0020;
					}
					alphabet[0]=0x1fb3;
					alphabet[6]=0x1fc3;
					alphabet[23]=0x1ff3;
					capsOn=false;
				}
			}
		}
		//When a common diacritic is selected
		else if (currentDiacritic.equals("commonDiacritic")){
			capCommonDiacritic();
		}
		else if(currentDiacritic.equals("acute")){
			capAcute();
		}
		else if(currentDiacritic.equals("grave")){
			capGrave();
		}
		else if(currentDiacritic.equals("circumflex")){
			capCircumflex();
		}
		else if(currentDiacritic.equals("breve")){
			capBreve();
		}
		else if(currentDiacritic.equals("macron")){
			capMacron();
		}
		
		resetButtonText();
	}
	
	public String hexConverter(int hexVal){
		return Character.toString((char)(Integer.parseInt(Integer.toHexString(hexVal),16)));
	}
	
	public void commonDiacritic(int diacritic){
		if(!capsOn){
			alphabet[0]=alphaSmooth+ diacritic-1;
			alphabet[4]=alphaSmooth+0x0010+diacritic-1;
			alphabet[6]=alphaSmooth+0x0020+diacritic-1;
			alphabet[8]=alphaSmooth+0x0030+diacritic-1;
			alphabet[14]=alphaSmooth+0x0040+diacritic-1;
			alphabet[19]=alphaSmooth+0x0050+diacritic-1;
			alphabet[23]=alphaSmooth+0x0060+diacritic-1;
		}else{
			alphabet[0]=8+alphaSmooth+ diacritic-1;
			alphabet[4]=8+alphaSmooth+0x0010+diacritic-1;
			alphabet[6]=8+alphaSmooth+0x0020+diacritic-1;
			alphabet[8]=8+alphaSmooth+0x0030+diacritic-1;
			alphabet[14]=8+alphaSmooth+0x0040+diacritic-1;
			alphabet[19]=8+alphaSmooth+0x0050+diacritic-1;
			alphabet[23]=8+alphaSmooth+0x0060+diacritic-1;
		}
		if(rdbtnWithIotaSub.isSelected()){
			alphabet[0]+=0x0080;
			alphabet[6]+=0x0070;
			alphabet[23]+=0x0040;
		}
	}
	
	public void addAcute(){
		if(!capsOn){
			alphabet[0] = 0x1f71;
			alphabet[4] =  0x1f73;
			alphabet[6] = 0x1f75;
			alphabet[8] = 0x1f77;
			alphabet[14] = 0x1f79;
			alphabet[19] = 0x1f7b;
			alphabet[23] = 0x1f7d;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb4;
				alphabet[6]=0x1fc4;
				alphabet[23]=0x1ff4;
			}
		}else{
			alphabet[0] = 0x1fbb;
			alphabet[4] =  0x1fc9;
			alphabet[6] = 0x1fcb;
			alphabet[8] = 0x1fdb;
			alphabet[14] = 0x1ff9;
			alphabet[19] = 0x1feb;
			alphabet[23] = 0x1ffb;
		}
		
	}
	
	public void addGrave(){
		if(!capsOn){
			alphabet[0] = 0x1f70;
			alphabet[4] =  0x1f72;
			alphabet[6] = 0x1f74;
			alphabet[8] = 0x1f76;
			alphabet[14] = 0x1f78;
			alphabet[19] = 0x1f7a;
			alphabet[23] = 0x1f7c;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb2;
				alphabet[6]=0x1fc2;
				alphabet[23]=0x1ff2;
			}
		}else{
			alphabet[0] = 0x1fba;
			alphabet[4] =  0x1fc8;
			alphabet[6] = 0x1fca;
			alphabet[8] = 0x1fda;
			alphabet[14] = 0x1ff8;
			alphabet[19] = 0x1fea;
			alphabet[23] = 0x1ffa;
		}
	}
	
	public void addCircumflex(){
		if(!capsOn){
			alphabet[0]=0x1fb6;
			alphabet[6]=0x1fc6;
			alphabet[8]=0x1fd6;
			alphabet[19]=0x1fe6;
			alphabet[23]=0x1ff6;
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]+=0x0001;
				alphabet[6]+=0x0001;
				alphabet[23]+=0x0001;
			}
		}
	}
	
	public void addRhoSoft(){
		if(!capsOn)
			alphabet[16]=0x1fe4;
	}
	
	public void addRhoRough(){
		if(!capsOn)
			alphabet[16]=0x1fe5;
		else
			alphabet[16]=0x1fec;
	}
	
	public void addBreve(){
		alphabet[0]=0x1fb0;
		alphabet[8]=0x1fd0;
		alphabet[19]=0x1fe0;
		if(capsOn){
			alphabet[0]+=0x0008;
			alphabet[8]+=0x0008;
			alphabet[19]+=0x0008;
		}
	}
	
	public void addMacron(){
		alphabet[0]=0x1fb1;
		alphabet[8]=0x1fd1;
		alphabet[19]=0x1fe1;
		if(capsOn){
			alphabet[0]+=0x0008;
			alphabet[8]+=0x0008;
			alphabet[19]+=0x0008;
		}
	}
	
	public void addDiacritic(int diacritic){
		//Reset all vowels
		if(diacritic == 0 && !capsOn){
			alphabet[0] = alpha;
			alphabet[4] =  epsilon;
			alphabet[6] = eta;
			alphabet[8] = iota;
			alphabet[14] = omicron;
			alphabet[16] = rho;
			alphabet[19] = upsilon;
			alphabet[23] = omega;
			currentDiacritic = "nd";
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fb3;
				alphabet[6]=0x1fc3;
				alphabet[23]=0x1ff3;
			}
		}
		else if(diacritic == 00 && capsOn){
			alphabet[0] = alpha-0x0020;
			alphabet[4] =  epsilon-0x0020;
			alphabet[6] = eta-0x0020;
			alphabet[8] = iota-0x0020;
			alphabet[14] = omicron-0x0020;
			alphabet[16] = rho-0x0020;
			alphabet[19] = upsilon-0x0020;
			alphabet[23] = omega-0x0020;
			currentDiacritic = "nd";
			if(rdbtnWithIotaSub.isSelected()){
				alphabet[0]=0x1fbc;
				alphabet[6]=0x1fcc;
				alphabet[23]=0x1ffc;
			}
		}
		//all common breathings
		else if(diacritic < 9 && diacritic != 0){
			commonDiacritic(diacritic);
			currentDiacritic = "commonDiacritic";
			if(diacritic==1){
				addRhoSoft();
			}
			if(diacritic==2){
				addRhoRough();
			}
			
		}
		else if(diacritic == 9){
			addAcute();
			currentDiacritic = "acute";
		}
		else if(diacritic == 10){
			addGrave();
			currentDiacritic = "grave";
		}
		else if(diacritic == 11){
			addCircumflex();
			currentDiacritic = "circumflex";
		}
		else if(diacritic == 12){
			addBreve();
			currentDiacritic = "breve";
		}
		else if(diacritic == 13){
			addMacron();
			currentDiacritic = "macron";
		}
		else if(diacritic == 14){
			//addDiaeresis();
			currentDiacritic = "diaeresis";
		}
		resetButtonText();
	}

	/**
	 * Create the frame.
	 */
	public GreekGUI() {
		this.keyboardAnchorX = 60;
		this.keyboardAnchorY = 300;
		this.keyWidth = 60;
		this.keyHeight = 60;
		this.keyboardAnchorXRowTwo = keyboardAnchorX-12;
		this.keyboardAnchorYRowTwo = keyboardAnchorY+keyHeight;
		this.keyboardAnchorXRowThree = keyboardAnchorX;
		this.keyboardAnchorYRowThree = keyboardAnchorY+(2*keyHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Greek Text Client");
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Top label
		JLabel lblTypeHere = new JLabel("Type here:");
		lblTypeHere.setBounds(12, 12, 74, 14);
		contentPane.add(lblTypeHere);
		
		//Text Pane
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 24));
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
		btnEndSigma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnEndSigma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				appendString("\u03C2");
				}catch(Exception e){}
			}
		});
		btnEndSigma.setBounds(keyboardAnchorX, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnEndSigma);
		
		btnEpsilonLow = new JButton(hexConverter(alphabet[4]));
		btnEpsilonLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnEpsilonLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[4]));
					}catch(Exception e){}
			}
		});
		btnEpsilonLow.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	try{
		    	}
		    	catch(Exception e){}
		    }

		    @SuppressWarnings("deprecation")
			public void mouseExited(java.awt.event.MouseEvent evt) {
		    	popupMenu.hide();
		    }
		});
		btnEpsilonLow.setBounds(keyboardAnchorX+keyWidth, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnEpsilonLow);
		
		 btnRhoLow = new JButton(hexConverter(alphabet[16]));
		btnRhoLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnRhoLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[16]));
					}catch(Exception e){}
			}
		});
		btnRhoLow.setBounds(keyboardAnchorX+keyWidth*2, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnRhoLow);
		
		 btnTauLow = new JButton(hexConverter(alphabet[18]));
		btnTauLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[18]));
					}catch(Exception e){}
			}
		});
		btnTauLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnTauLow.setBounds(keyboardAnchorX+keyWidth*3, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnTauLow);
		
		 btnUpsilonLow = new JButton(hexConverter(alphabet[19]));
		btnUpsilonLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[19]));
					}catch(Exception e){}
			}
		});
		btnUpsilonLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnUpsilonLow.setBounds(keyboardAnchorX+keyWidth*4, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnUpsilonLow);
		
		 btnThetaLow = new JButton(hexConverter(alphabet[7]));
		btnThetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[7]));
					}catch(Exception e){}
			}
		});
		btnThetaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnThetaLow.setBounds(keyboardAnchorX+keyWidth*5, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnThetaLow);
		
		 btnIotaLow = new JButton(hexConverter(alphabet[8]));
		 btnIotaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[8]));
					}catch(Exception e){}
			}
		});
		 btnIotaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		 btnIotaLow.setBounds(keyboardAnchorX+keyWidth*6, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnIotaLow);
		
		 btnOmicronLow = new JButton(hexConverter(alphabet[14]));
		btnOmicronLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[14]));
					}catch(Exception e){}
			}
		});
		btnOmicronLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnOmicronLow.setBounds(keyboardAnchorX+keyWidth*7, keyboardAnchorY, keyWidth, keyHeight);
		contentPane.add(btnOmicronLow);
		
		 btnPiLow = new JButton(hexConverter(alphabet[15]));
		btnPiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[15]));
					}catch(Exception e){}
			}
		});
		btnPiLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPiLow.setBounds(keyboardAnchorX+keyWidth*8, keyboardAnchorY, keyWidth, keyHeight);
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
		btnDel.setBounds(keyboardAnchorX+keyWidth*9, keyboardAnchorY, keyWidth+30, keyHeight);
		contentPane.add(btnDel);
		
		btnAlphaLow = new JButton(hexConverter(alphabet[0]));
		btnAlphaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnAlphaLow.setBounds(keyboardAnchorXRowTwo, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnAlphaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[0]));
					}catch(Exception e){}
			}
		});
		contentPane.add(btnAlphaLow);
		
		 btnSigmaLow = new JButton(hexConverter(alphabet[17]));
		btnSigmaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSigmaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth(), keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnSigmaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[17]));
					}catch(Exception e){}
			}
		});contentPane.add(btnSigmaLow);
		
		 btnDeltaLow = new JButton(hexConverter(alphabet[3]));
		btnDeltaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnDeltaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*2, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnDeltaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[3]));
					}catch(Exception e){}
			}
		});contentPane.add(btnDeltaLow);
		
		 btnPhiLow = new JButton(hexConverter(alphabet[20]));
		btnPhiLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPhiLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*3, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnPhiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[20]));
					}catch(Exception e){}
			}
		});contentPane.add(btnPhiLow);
		
		 btnGammaLow = new JButton(hexConverter(alphabet[2]));
		btnGammaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnGammaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*4, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnGammaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[2]));
					}catch(Exception e){}
			}
		});contentPane.add(btnGammaLow);
		
		 btnEtaLow = new JButton(hexConverter(alphabet[6]));
		btnEtaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnEtaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*5, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnEtaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[6]));
					}catch(Exception e){}
			}
		});contentPane.add(btnEtaLow);
		
		 btnXiLow = new JButton(hexConverter(alphabet[13]));
		 btnXiLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		 btnXiLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*6, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		 btnXiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[13]));
					}catch(Exception e){}
			}
		});contentPane.add(btnXiLow);
		
		 btnKappaLow = new JButton(hexConverter(alphabet[9]));
		btnKappaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnKappaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*7, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnKappaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[9]));
					}catch(Exception e){}
			}
		});contentPane.add(btnKappaLow);
		
		 btnLambdaLow = new JButton(hexConverter(alphabet[10]));
		btnLambdaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnLambdaLow.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*8, keyboardAnchorYRowTwo, keyWidth, keyHeight);
		btnLambdaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[10]));
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
		btnCap.setBounds(keyboardAnchorXRowThree-45, keyboardAnchorYRowThree, keyWidth+45, keyHeight);
		contentPane.add(btnCap);
		
		 btnZetaLow = new JButton(hexConverter(alphabet[5]));
		btnZetaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnZetaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*1, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnZetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[5]));
					}catch(Exception e){}
			}
		});contentPane.add(btnZetaLow);
		
		 btnChiLow = new JButton(hexConverter(alphabet[21]));
		btnChiLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnChiLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*2, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnChiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[21]));
					}catch(Exception e){}
			}
		});contentPane.add(btnChiLow);
		
		 btnPsiLow = new JButton(hexConverter(alphabet[20]));
		btnPsiLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPsiLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*3, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnPsiLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[20]));
					}catch(Exception e){}
			}
		});contentPane.add(btnPsiLow);
		
		 btnOmegaLow = new JButton(hexConverter(alphabet[23]));
		btnOmegaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnOmegaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*4, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnOmegaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[23]));
					}catch(Exception e){}
			}
		});contentPane.add(btnOmegaLow);
		
		btnBetaLow = new JButton(hexConverter(alphabet[1]));
		btnBetaLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBetaLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*5, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnBetaLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[1]));
					}catch(Exception e){}
			}
		});contentPane.add(btnBetaLow);
		
		 btnNuLow = new JButton(hexConverter(alphabet[12]));
		btnNuLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNuLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*6, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnNuLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[12]));
					}catch(Exception e){}
			}
		});contentPane.add(btnNuLow);
		
		 btnMuLow = new JButton(hexConverter(alphabet[11]));
		btnMuLow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnMuLow.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*7, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnMuLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString(hexConverter(alphabet[11]));
					}catch(Exception e){}
			}
		});contentPane.add(btnMuLow);
		
		JButton btnPeriod = new JButton("\u002e");
		btnPeriod.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnPeriod.setBounds(keyboardAnchorXRowThree+btnAlphaLow.getWidth()*8, keyboardAnchorYRowThree, keyWidth, keyHeight);
		btnPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\u002e");
					}catch(Exception e){}
			}
		});contentPane.add(btnPeriod);
		
		JButton btnQuestion = new JButton("\u003f");
		btnQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 24));
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
		btnReturn.setBounds(keyboardAnchorXRowTwo+btnAlphaLow.getWidth()*9, keyboardAnchorYRowTwo, keyWidth+63, keyHeight);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					appendString("\n");
					}catch(Exception e){}
			}
		});contentPane.add(btnReturn);
		
		
final JComboBox cmbDiacritics = new JComboBox();
cmbDiacritics.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		addDiacritic(cmbDiacritics.getSelectedIndex());
	}
});
cmbDiacritics.setModel(new DefaultComboBoxModel(new String[] {"","\u1FBD", "\u1FFE", "\u1FCD", "\u1FDD", "\u1FCE", "\u1FDE","\u1FCF", "\u1FDF", "\u1FFD", "\u1FEF", "\u1FC0", "\u1FB0", "\u1FB1"}));
cmbDiacritics.setFont(new Font("Tahoma", Font.PLAIN, 40));
cmbDiacritics.setBounds(keyboardAnchorX+338, keyboardAnchorYRowThree+keyHeight, 70, 50);
contentPane.add(cmbDiacritics);


JButton btnSpace = new JButton("SPACE");
btnSpace.setFont(new Font("Calibri", Font.PLAIN, 24));
btnSpace.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		try{
			appendString(" ");
			}catch(Exception e){}
	}
});
btnSpace.setBounds(keyboardAnchorX+88, keyboardAnchorYRowThree+keyHeight, 250, 50);
contentPane.add(btnSpace);
rdbtnWithIotaSub = new JRadioButton("With iota sub");
rdbtnWithIotaSub.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		if(rdbtnWithIotaSub.isSelected())
			//addIotaSub
			addDiacritic(cmbDiacritics.getSelectedIndex());
		if(!rdbtnWithIotaSub.isSelected())
			//removeIotaSub
			addDiacritic(cmbDiacritics.getSelectedIndex());
	}
});
rdbtnWithIotaSub.setFont(new Font("Calibri", Font.PLAIN, 18));
rdbtnWithIotaSub.setBounds(keyboardAnchorX+460, keyboardAnchorYRowThree+keyHeight+15, 150, 23);
contentPane.add(rdbtnWithIotaSub);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
			private void showMenu(MouseEvent e) {
			}
		});
	}
}
