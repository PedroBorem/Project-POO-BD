package br.inatel.C207;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {

        public static ArrayList<Paises> lerPais(){
            int i = 0;
            int j = 0;
            ArrayList<Paises> paises = new ArrayList<>();

            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader br = null;
            String linhaLer;

            try {
                is = new FileInputStream("listaPaises.txt");
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                linhaLer = br.readLine();
                while (linhaLer != null){
                    Paises p = new Paises();
                    p.setNome(linhaLer);
                    paises.add(p);
                    linhaLer = br.readLine();
                    j++;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    br.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            boolean[] aux = new boolean[j];
            try {

                is = new FileInputStream("latitudesP.txt");
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                j = 0;
                linhaLer = br.readLine();
                while (linhaLer != null){
                    if(linhaLer.startsWith("N"))
                    {
                        aux[j] = true;
                    }else{
                        aux[j] = false;
                    }
                    linhaLer = br.readLine();
                    j++;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    br.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            try {
                is = new FileInputStream("latitudes.txt");
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                j = 0;
                linhaLer = br.readLine();
                while (linhaLer != null){
                    String[] splitted = linhaLer.split(" ");
                    double latitude = Math.toRadians(Double.parseDouble(splitted[0] )+ (Double.parseDouble(splitted[1])/60) + (Double.parseDouble(splitted[2])/3600));
                    if (aux[j]){
                        paises.get(j).setLatitude(latitude);
                    }else{
                        paises.get(j).setLatitude(latitude*(-1.0));
                    }
                    linhaLer = br.readLine();
                    j++;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    br.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            try {
                is = new FileInputStream("longitudesP.txt");
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                j = 0;
                linhaLer = br.readLine();
                while (linhaLer != null){
                    if(linhaLer.startsWith("E"))
                    {
                        aux[j] = true;
                    }else{
                        aux[j] = false;
                    }
                    linhaLer = br.readLine();
                    j++;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    br.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            try {
                is = new FileInputStream("longitudes.txt");
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                j = 0;
                linhaLer = br.readLine();
                while (linhaLer != null){
                    String[] splitted = linhaLer.split(" ");
                    double longitude = Math.toRadians(Double.parseDouble(splitted[0] )+ (Double.parseDouble(splitted[1])/60) + (Double.parseDouble(splitted[2])/3600));
                    if (aux[j]){
                        paises.get(j).setLongitude(longitude);
                    }else{
                        paises.get(j).setLongitude(longitude*(-1.0));
                    }
                    linhaLer = br.readLine();
                    j++;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    br.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            return paises;

        }

    }