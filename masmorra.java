package Aula06_DOWHILE;



import javax.swing.*;
import java.awt.*;
import java.util.*;

public class masmorra extends JFrame {

    JTextArea t;
    JButton c,b,e,d,a,inv;

    Random r = new Random();

    String nome;

    int vida=150,x=2,y=2,der=0,vidaIni=0;

    boolean boss=false;

    String[][] mapa = new String[5][5];

    ArrayList<String> itens = new ArrayList<>();

    public masmorra(){

        setTitle("RPG");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        t = new JTextArea();
        t.setEditable(false);
        add(new JScrollPane(t),BorderLayout.CENTER);

        JPanel p = new JPanel();

        c=new JButton("↑");
        b=new JButton("↓");
        e=new JButton("←");
        d=new JButton("→");
        a=new JButton("Acao");
        inv=new JButton("Inventario");

        p.add(c);p.add(b);p.add(e);p.add(d);p.add(a);p.add(inv);
        add(p,BorderLayout.SOUTH);

        mapa();
        start();

        c.addActionListener(x->mov(0,-1));
        b.addActionListener(x->mov(0,1));
        e.addActionListener(x->mov(-1,0));
        d.addActionListener(x->mov(1,0));
        a.addActionListener(x->acao());
        inv.addActionListener(x->item());

        setVisible(true);
    }

    void log(String s){ t.append(s+"\n"); }

    void limpa(){ t.setText(""); }

    void desenhaMapa(){
        log("MAPA:");

        for(int j=0;j<5;j++){
            String linha="";

            for(int i=0;i<5;i++){

                // player
                if(i==x && j==y)
                    linha += "| P ";
                else
                    linha += "| * ";
            }

            linha += "|";
            log(linha);
        }

        log(""); 
    }

    void start(){
        nome = JOptionPane.showInputDialog("Nome:");

        itens.add("Espada de Madeira");
        itens.add("Poção");
        itens.add("Maçã");

        log("Bem vindo "+nome);
        desenhaMapa(); 
    }

    void mapa(){
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++){
                int n=r.nextInt(3);
                mapa[i][j]= n==0?"inimigo": n==1?"bau":"vazio";
            }
    }

    void mov(int dx,int dy){
        limpa();

        int nx=x+dx, ny=y+dy;

        if(nx>=0&&nx<5&&ny>=0&&ny<5){
            x=nx;y=ny;
            log("Voce foi para "+x+","+y);
        }else log("Limite do mapa");

        desenhaMapa();
    }

    void acao(){

        if(der>=4&&x==4&&y==4){ boss(); return; }

        String e = mapa[x][y];

        if(e.equals("inimigo")){
            fight(false);
            mapa[x][y]="vazio";
        }
        else if(e.equals("bau")){
            bau();
            mapa[x][y]="vazio";
        }
        else{
            limpa();
            log("Nao tem nada aqui...");
            desenhaMapa();
        }
    }

    void fight(boolean b){
        boss=b;

        vidaIni = b ? 200 : 100;

        combate();
    }

    void combate(){

        limpa();

        log("=== COMBATE ===");
        if(boss)
            log("Boss apareceu cuidado!!");
        else
            log("Inimigo apareceu");

        log("Vida inimigo: "+vidaIni);
        log("Sua vida: "+vida);
        log("----------------");

        String[] op={"Ataque normal","Ataque forte","Atacar novamente","Fugir","Usar item"};

        int es=JOptionPane.showOptionDialog(null,"Escolha","Combate",
                0,1,null,op,op[0]);

        if(es==4){
            item();
            combate();
            return;
        }

        if(es==3){
            if(r.nextInt(2)==0){
                log("Voce fugiu");
                return;
            }else log("Nao conseguiu fugir");
        }

        int dano;

        if(itens.contains("Espada de Ferro"))
            dano = es==1? r.nextInt(61)+120 : r.nextInt(41)+40;
        else
            dano = es==1? r.nextInt(11)+50 : r.nextInt(21)+20;

        vidaIni-=dano;
        log("Voce deu "+dano+" de dano");

        if(vidaIni<=0){
            log("Inimigo derrotado");
            der++;
            return;
        }

        int dIni = boss? r.nextInt(51)+25 : r.nextInt(21)+10;

        vida-=dIni;
        log("Voce recebeu "+dIni);

        if(vida<=0) gameOver();
        else combate();
    }

    void item(){

        if(itens.isEmpty()){
            log("Inventario vazio");
            return;
        }

        String it=(String)JOptionPane.showInputDialog(
                null,"Escolha item","Inventario",
                0,null,itens.toArray(),itens.get(0));

        if(it==null) return;

        if(it.equals("Poção")){
            vida+=50;
            if(vida>300) vida=300;
            log("Curou 50 de vida");
            itens.remove(it);
        }
        else if(it.equals("Maçã")||it.equals("Cenoura")){
            int c=r.nextInt(11)+15;
            vida+=c;
            log("Curou "+c);
            itens.remove(it);
        }
    }

    void bau(){
        int l=r.nextInt(3);

        if(l==0){
            itens.add("Espada de Ferro");
            log("Achou Espada de Ferro");
        }
        else if(l==1){
            itens.add("Poção");
            log("Achou Poção");
        }
        else{
            itens.add("Cenoura");
            log("Achou Cenoura");
        }
    }

    void boss(){ fight(true); }

    void gameOver(){
        limpa();
        log("GAME OVER");
        System.exit(0);
    }

    public static void main(String[] args){
        new masmorra();
    }
}