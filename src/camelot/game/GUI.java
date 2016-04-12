/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelot.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author aakashtyagi
 */
public class GUI extends JFrame implements MouseListener{
    
    public JButton[][] JButtonArr;
    ImageIcon blackPawn,blackKnight,whitePawn,whiteKnight,castle1,castle2;
    public int moveFlag;
    public CamelotGame game;
    Move move = new Move();
  
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton btn;
        //System.out.println("In button 1");
        int var;
        btn = JButtonArr[1][1];
        if(e.getSource() == JButtonArr[1][1])
        {
            move = new Move();
            refreshGrid(game);
        }
        else
        {
            
            int i,j;
            for(i=1;i<=16;i++)
            {
                for(j=1;j<=12;j++)
                {
                    btn = JButtonArr[i][j];
                    if(e.getSource() == btn)
                    {
                        Border border = BorderFactory.createBevelBorder(1, Color.RED, Color.RED);
                        btn.setBorder(border);
                        move.chance.add(new Position(i,j));
                        move.chanceCnt++;
                        if( MouseEvent.BUTTON3 == e.getButton())
                        {
                            System.out.println("In right click");
                            game.singleMove(move);
                            if(game.checkState() == 0)
                                game.declareWinner();
                            move = new Move();
                        }
                        
                    }
                }
            }
        }
    }
    
    public GUI(int rows, int cols) {
        moveFlag = 0;
        JButtonArr = new JButton[rows+1][cols+1];
        blackPawn = new ImageIcon("src/images/Black_Pawn.png");
        whitePawn = new ImageIcon("src/images/White_Pawn.png");
        blackKnight = new ImageIcon("src/images/Black_Knight.png");
        whiteKnight = new ImageIcon("src/images/White_Knight.png");
        castle1 = new ImageIcon("src/images/castle1.png");
        castle2 = new ImageIcon("src/images/castle2.png");
        int i,j;
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, cols));
        for (i = 1; i <= 16; i++) {
            for(j = 1 ; j <= 12 ; j++)
            {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50,50));
                //button.setIcon(pawn);
                JButtonArr[i][j] = button;
                pane.add(button);

                button.addMouseListener(this);
            }
        }
        JButton btn;
        btn = JButtonArr[1][1];
        btn.setText("Cancel");
    }
    
    public void init(CamelotGame cg)
    {
        game = cg;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public void refreshGrid(CamelotGame cg)
    {
        game = cg;
        int i,j,v;
        JButton btn;
        Piece pc;
        for(i=1;i<=16;i++)
        {
            for(j=1;j<=12;j++)
            {
                
                btn = JButtonArr[i][j];
                v = (i%2) ^ (j%2);
                Border defaultBorder = BorderFactory.createBevelBorder(1);
                btn.setBorder(defaultBorder);

                if(v == 1)
                    btn.setBackground(Color.YELLOW);
                else btn.setBackground(Color.CYAN);
                
                if(cg.grid[i][j].valid == 0)
                {
                    btn.setBackground(Color.WHITE);
                }
                
                if(cg.grid[i][j].castle == 1)
                {
                    if(j % 2 == 0)
                        btn.setIcon(castle1);
                    else btn.setIcon(castle2);
                }
                pc = cg.getPiece(i,j);
                if(pc != null)
                {
                    assignPiece(btn,pc);
                }
                else
                {
                    btn.setIcon(null);
                }
            }
        }
    }
    
    public void assignPiece(JButton btn, Piece pc)
    {
        if(pc.color == 1)
        {
            btn.setIcon((pc.isKnight == 1 ? blackKnight : blackPawn));
        }
        else
        {
            btn.setIcon((pc.isKnight == 1 ? whiteKnight : whitePawn));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
    
    
}
