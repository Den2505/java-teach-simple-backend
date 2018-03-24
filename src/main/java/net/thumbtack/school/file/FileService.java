package net.thumbtack.school.file;


import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Point2D;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileService {



    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) {
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) {

        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) {
        try (FileInputStream stream = new FileInputStream(file)) {
            byte[] bits = new byte[stream.available()];
            stream.read(bits);
            return bits;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        ByteArrayInputStream inStream = null;
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ) {
            stream.write(array);
            inStream = new ByteArrayInputStream(stream.toByteArray());
            byte[] bits = new byte[inStream.available()];
            byte[] bits2;
            if (inStream.available() % 2 == 0) {
                bits2 = new byte[inStream.available() / 2];
            } else {
                bits2 = new byte[(inStream.available() - 1) / 2];
            }
            inStream.read(bits);
            int j = 0;
            for (int i = 0; i < bits.length; i += 2) {
                bits2[j] = bits[i];
                j++;
            }
            return bits2;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }

    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) {
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))) {
            stream.write(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bits = new byte[stream.available()];
            stream.read(bits);
            return bits;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return null;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(file, true))) {
            stream.writeInt(rect.getTopLeft().getX());
            stream.writeInt(rect.getTopLeft().getY());
            stream.writeInt(rect.getBottomRight().getX());
            stream.writeInt(rect.getBottomRight().getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) {
        try (DataInputStream stream = new DataInputStream(new FileInputStream(file))) {
            Point2D topLeft = new Point2D(stream.readInt(), stream.readInt());
            Point2D bottomRight = new Point2D(stream.readInt(), stream.readInt());
            return new Rectangle(topLeft, bottomRight, Color.RED);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) {
        for (Rectangle rect : rects) {
            writeRectangleToBinaryFile(file, rect);
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) {
        ArrayList<Rectangle> list = new ArrayList<>();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            System.out.println("randomAccessFile.length() " + randomAccessFile.length());

            for (int i = (int) randomAccessFile.length() - 16; i >= 0; i = i - 16) {
                randomAccessFile.seek(i);
                list.add(new Rectangle(randomAccessFile.readInt(), randomAccessFile.readInt(),
                        randomAccessFile.readInt(), randomAccessFile.readInt(), Color.RED));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ColorException e) {
            e.printStackTrace();
        }

        Rectangle[] rectangles = new Rectangle[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rectangles[i] = list.get(i);
        }
        return rectangles;
    }
    public static void  writeRectangleToTextFileOneLine(File file, Rectangle rect){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
         writer.write(String.valueOf(rect.getTopLeft().getX())+" ");
         writer.write(String.valueOf(rect.getTopLeft().getY())+" ");
         writer.write(String.valueOf(rect.getBottomRight().getX())+" ");
         writer.write(String.valueOf(rect.getBottomRight().getY()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Rectangle  readRectangleFromTextFileOneLine(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] strs = reader.readLine().split(" ");

            Point2D topLeft = new Point2D(Integer.parseInt(strs[0]),Integer.parseInt(strs[1]));
            Point2D bottomRight = new Point2D(Integer.parseInt(strs[2]),Integer.parseInt(strs[3]));
            return new Rectangle(topLeft,bottomRight,Color.RED);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void  writeRectangleToTextFileFourLines(File file, Rectangle rect){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(rect.getTopLeft().getX()+"\r\n");
            writer.write(rect.getTopLeft().getY()+"\r\n");
            writer.write(rect.getBottomRight().getX()+"\r\n");
            writer.write(rect.getBottomRight().getY()+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Rectangle  readRectangleFromTextFileFourLines(File file){
        try( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Point2D topLeft = new Point2D(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
            Point2D bottomRight = new Point2D(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
            return new Rectangle(topLeft,bottomRight,Color.RED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void  writeTraineeToTextFileOneLine(File file, Trainee trainee){
        try {
            try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8")) {
                String str = trainee.getFullName()+" "+trainee.getRating();
                writer.write(str);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Trainee  readTraineeFromTextFileOneLine(File file){
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
           String[] str = reader.readLine().split(" ");
           return new Trainee(str[0],str[1],Integer.parseInt(str[2]));


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TrainingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void  writeTraineeToTextFileThreeLines(File file, Trainee trainee){
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"))) {
            writer.write(trainee.getFirstName());
            writer.newLine();
            writer.write(trainee.getLastName());
            writer.newLine();
            writer.write(String.valueOf(trainee.getRating()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Trainee  readTraineeFromTextFileThreeLines(File file){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))) {
           return new Trainee(reader.readLine(),reader.readLine(),Integer.parseInt(reader.readLine()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TrainingException e) {
            e.printStackTrace();
        }
   return null; }
    public static void  serializeTraineeToBinaryFile(File file, Trainee trainee){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(trainee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Trainee  deserializeTraineeFromBinaryFile(File file){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
           return (Trainee) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return null;}
    public static String  serializeTraineeToJsonString(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }
    public static Trainee  deserializeTraineeFromJsonString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Trainee.class);
    }
    public static void  serializeTraineeToJsonFile(File file, Trainee trainee){
        Gson gson = new Gson();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Trainee  deserializeTraineeFromJsonFile(File file){
        Gson gson = new Gson();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
           return gson.fromJson(reader,Trainee.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;}
}
