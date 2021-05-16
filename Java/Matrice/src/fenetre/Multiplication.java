package fenetre;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.IllegalFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Multiplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Multiplication frame = new Multiplication();
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

    Grille g1 = new Grille(Fenetre.val1, Fenetre.val2);
    Grille g2 = new Grille(Fenetre.val3, Fenetre.val4);
    Grille result = new Grille(Fenetre.val1, Fenetre.val4);

	public Multiplication() {
		isAlwaysOnTop();
        setExtendedState(MAXIMIZED_BOTH);  
        this.setTitle("Multiplication");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 1));
        /***********************
         * DEINISSONS LE CONTENU DE LA BOITE 1
         *************************/
        // contenu1.setLayout(new BorderLayout());
        JPanel contenu1 = new JPanel();
        contenu1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 25));
        JPanel sousContenu1 = new JPanel();
        JPanel sousContenu2 = new JPanel();
        ajouter(sousContenu1, g1.getMatrix());
        ajouter(sousContenu2, g2.getMatrix());
        // sousContenu1.setPreferredSize(new Dimension(75, 75));
        // sousContenu2.setPreferredSize(new Dimension(75, 75));
        contenu1.add(sousContenu1);
        JButton multButton = new JButton("Multiplier");
        contenu1.add(multButton);
        multButton.addActionListener(this::multButtonListener);
        contenu1.add(sousContenu2);
        contenu1.setVisible(true);
        pan1.add(contenu1);
        /************************** FIN DEFINITION ******************************/

        /***********************
         * DEINISSONS LE CONTENU DE LA BOITE 2
         *************************/
        JPanel second = new JPanel();
        ajouter(second, result.getMatrix());
        pan2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
        pan2.add(second);
        /************************** FIN DEFINITION ******************************/
        contentPane.add(pan1);
        // pan1.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPane.add(pan2);
        this.setContentPane(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	private void multButtonListener(ActionEvent evt) {
// Initialisation/creation 
		final int Matrice1[][] = new int[Fenetre.val1][Fenetre.val2];
		final int Matrice2[][] = new int[Fenetre.val3][Fenetre.val4];
	try {
// ON recupere les valeurs de la premiere Grille ;
        for (int i = 
        		0; i < Fenetre.val1; i++) {
            for (int j = 0; j < Fenetre.val2; j++) {
                try {
                     int a = Integer.parseInt(g1.matrix[i][j].getText());
                     Matrice1[i][j]= a ;
                    System.out.println(Matrice1[i][j]);
                } catch (NumberFormatException e) {
                	g1.matrix[i][j].setText("");
                	if(g1.matrix[i][j].getText().equals("")) {
                	throw new IsSetTextException();
                	}
                }

            }
        }
 // ON recupere les valeurs de la deuxieme Grille ;
        for ( int i = 0; i < Fenetre.val3; i++) {
            for (int j = 0; j < Fenetre.val4; j++) {
                try {
                     int a = Integer.parseInt(g2.matrix[i][j].getText());
                     Matrice2[i][j]= a ;
                    System.out.println(Matrice2[i][j]);
                    
                } catch (NumberFormatException e) {
                	g2.matrix[i][j].setText("");
                	if(g2.matrix[i][j].getText().equals("")) {
                	throw new IsSetTextException();
                	}
                }
            }
        }
// on effectue le calcul
        int [][] C = new int[Fenetre.val1][Fenetre.val4];
        for( int i=0; i<Fenetre.val1 ;i++ ){
            for(int j =0 ; j < Fenetre.val4 ; j++){
                C[i][j] = 0;
                for(int k = 0; k < Fenetre.val3 ; k++){
                    C[i][j] += Matrice1[i][k] * Matrice2[k][j];  
                    result.matrix[i][j].setText(String.valueOf(C[i][j]));
                }
            }
        }
// on affiche le resultat
	
        }catch(Exception e) {	
        for(int k =0; k<Fenetre.val1 ;k++ ){
            for(int c =0 ; c < Fenetre.val4 ; c++){
                    result.matrix[k][c].setText("");     
            }
        }
        JOptionPane.showMessageDialog(this,"Les champs ont ete mal remplis : "+e.getMessage(), "Pas de Vide ou de String :( ",JOptionPane.WARNING_MESSAGE);
	}
	}
        
		

	
	
    public void ajouter(JPanel b, JTextField matrice[][]) {
        JTextField matrix[][] = matrice;
        b.setLayout(new GridLayout(matrice.length, matrice[0].length));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // matrice[i][j].setPreferredSize(new Dimension(20, 20));
                b.add(matrix[i][j]);
                // matrix[i][j].addActionListener(this::matListener);
            }

        }

    }
    
   class Grille {
    JTextField matrix[][];
    JTextField champ;
    public int lign, col;

    public Grille(int lign, int col) {
        if (lign >= 1 && col >= 1) {
            this.lign = lign;
            this.col = col;
            this.matrix = new JTextField[lign][col];
            for (int i = 0; i < lign; i++) {

                for (int j = 0; j < col; j++) {
                    champ = new JTextField();
                    champ.getText();
                    champ.setPreferredSize(new Dimension(45, 40));
                    matrix[i][j] = champ;
                }
            }
        } else {
            System.err.println("construction impossible");
        }
    }

    public JTextField[][] getMatrix() {
        return matrix;
    }

   }

}
