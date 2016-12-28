/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.MainFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import remote.RemoteInterface;

/**
 *
 * @author Druia
 */
public class Client {

    static Registry registry;
    public static RemoteInterface ri;
    static String CLIENT, TICKER, AMOUNT, DIRECTION, FUND = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        registry = LocateRegistry.getRegistry("localhost", 4321);
        ri = (RemoteInterface) registry.lookup("server");

        BufferedReader br;
        String x;
        Writer writer = null;
        writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt"), "utf-8"));
        boolean found = false;
        for (int index = 1; index < 10; index++) {
            br = new BufferedReader(new FileReader(index + ".txt"));
            found = false;
            FUND = "";
            while ((x = br.readLine()) != null && found == false) {
                if (x.equals("Investment Instruction to BLACKROCK") && found == false) {
                    x = br.readLine();
                    CLIENT = x;
                    while (x.contains("RED") == false || x.contains("SUB")) {
                        x = br.readLine();
                    }
                    int count = x.indexOf("RED");
                    if (count == -1) {
                        DIRECTION = "SUB";
                    } else {
                        DIRECTION = "RED";
                    }
                    while (x.contains(",") == false) {
                        x = br.readLine();
                    }
                    String[] s = x.split(" ");
                    AMOUNT = s[1];
                    int begin = x.indexOf("holdings of");
                    begin += 12;
                    int end = x.indexOf("opportunities");
                    FUND = x.substring(begin, end - 1);
                    while (x.contains("(") == false) {
                        x = br.readLine();
                    }
                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    TICKER = x;
                    writer.write(CLIENT);
                    writer.write('\n');
                    writer.write(TICKER);
                    writer.write('\n');
                    writer.write(AMOUNT);
                    writer.write('\n');
                    writer.write(DIRECTION);
                    writer.write('\n');
                    writer.write(FUND);
                    writer.write('\n');
                    found = true;
                }

                if (x.equals("Investment Instruction") && found == false) {
                    x = br.readLine();
                    if (x.equals("BLACKROCK")) {
                        ArrayList<String> array = new ArrayList<String>();
                        x = br.readLine();
                        DIRECTION = x;
                        x = br.readLine();
                        String[] sum = x.split(" ");
                        AMOUNT = sum[1];

                        while ((x = br.readLine()) != null && x.equals("Ticker") == false) {
                            array.add(x);
                        }
                        TICKER = array.remove(array.size() - 1);
                        boolean ok = false;
                        int i = 0;
                        while (ok == false && i < array.size()) {
                            if (array.get(i).equals("Fund")) {
                                ok = true;
                                array.remove(i);
                            }
                            i++;
                        }

                        for (i = 0; i < array.size(); i++) {
                            FUND = FUND + " " + array.get(i);
                        }
                        FUND = FUND.substring(1);
                        CLIENT = br.readLine();
                        writer.write(CLIENT);
                        writer.write('\n');
                        writer.write(TICKER);
                        writer.write('\n');
                        writer.write(AMOUNT);
                        writer.write('\n');
                        writer.write(DIRECTION);
                        writer.write('\n');
                        writer.write(FUND);
                        writer.write('\n');

                        found = true;
                    }
                }

                if (x.equals("BLACKROCK") && found == false) {
                    x = br.readLine();
                    if (x.equals("Client Investment instruction")) {
                        while (x.equals("Client Name:") == false) {
                            x = br.readLine();
                        }
                        CLIENT = br.readLine();
                        x = br.readLine();
                        x = br.readLine();
                        FUND = br.readLine();
                        while (x.equals("Ticker") == false) {
                            x = br.readLine();
                        }
                        TICKER = br.readLine();
                        x = br.readLine();
                        if (x.equals("Amount")) {
                            x = br.readLine();
                        }
                        char[] c = x.toCharArray();
                        if (Character.isDigit(c[0]) == false) {
                            AMOUNT = x.substring(3);
                        } else {
                            AMOUNT = x.substring(0);
                        }
                        while (x.equals("Direction") == false) {
                            x = br.readLine();
                        }
                        DIRECTION = br.readLine();
                        writer.write(CLIENT);
                        writer.write('\n');
                        writer.write(TICKER);
                        writer.write('\n');
                        writer.write(AMOUNT);
                        writer.write('\n');
                        writer.write(DIRECTION);
                        writer.write('\n');
                        writer.write(FUND);
                        writer.write('\n');

                        found = true;
                    } else if (x.equals("INVESTMENT INSTRUCTION")) {
                        x = br.readLine();
                        ArrayList<String> list = new ArrayList<String>();
                        if (x.equals("Ticker")) {
                            int contor = 0;
                            while (contor < 4) {
                                contor++;
                                x = br.readLine();
                                list.add(x);
                            }
                            while ((x = br.readLine()) != null && x.equals("Sign off") == false) {
                                list.add(x);
                            }
                            char[] c = list.get(list.size() - 1).substring(0, 1).toCharArray();
                            if (Character.isDigit(c[0])) {
                                AMOUNT = list.remove(list.size() - 1);
                            } else {
                                AMOUNT = list.remove(list.size() - 2);
                            }
                            c = list.get(list.size() - 2).substring(0, 1).toCharArray();
                            if (Character.isDigit(c[0])) {
                                TICKER = list.remove(list.size() - 3);
                            } else {
                                TICKER = list.remove(list.size() - 2);
                            }
                            x = br.readLine();
                            for (int i = 2; i < list.size(); i++) {
                                FUND = FUND + " " + list.get(i);
                            }
                            FUND = FUND.substring(1);
                            while (x.equals("Secondary") == false) {
                                x = br.readLine();
                            }

                            x = br.readLine();
                            String[] token = x.split(" ");
                            if (token.length > 1) {
                                CLIENT = token[0] + " " + token[1];
                            } else {
                                CLIENT = x + " ";
                                x = br.readLine();
                                x = br.readLine();
                                x = br.readLine();
                                CLIENT = CLIENT + x;
                            }

                            while (x.equals("Direction") == false) {
                                x = br.readLine();
                            }
                            x = br.readLine();
                            DIRECTION = x;
                            writer.write(CLIENT);
                            writer.write('\n');
                            writer.write(TICKER);
                            writer.write('\n');
                            writer.write(AMOUNT);
                            writer.write('\n');
                            writer.write(DIRECTION);
                            writer.write('\n');
                            writer.write(FUND);
                            writer.write('\n');
                        } else {
                            x = br.readLine();
                            ArrayList<String> list1 = new ArrayList<String>();
                            while (x.contains(",") == false) {
                                x = br.readLine();
                                list1.add(x);
                            }
                            TICKER = list1.remove(list1.size() - 1);
                            AMOUNT = x;
                            DIRECTION = br.readLine();
                            FUND = list1.get(3);
                            FUND = FUND + " " + br.readLine();
                            while (x != null) {
                                x = br.readLine();
                                list1.add(x);
                            }
                            CLIENT = list1.get(list1.size() - 2);
                            writer.write(CLIENT);
                            writer.write('\n');
                            writer.write(TICKER);
                            writer.write('\n');
                            writer.write(AMOUNT);
                            writer.write('\n');
                            writer.write(DIRECTION);
                            writer.write('\n');
                            writer.write(FUND);
                            writer.write('\n');
                        }
                        found = true;
                    }
                }
            }
            br.close();
        }

        writer.close();


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
