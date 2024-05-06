package generic;

public class objMydata {
        public static void main(String[] args) {
            // clsMydata<String> strData = new clsMydata<>("Khansa Izza Aulia");
            // System.out.println("Nama: " + strData.getData());

            clsMydata<String> StrClsMydata = new clsMydata<String>("Khansa");
            clsMydata<Integer> IntegerClsMydata = new clsMydata<Integer>(19);

            String stringValue = StrClsMydata.getData();
            Integer IntegerValue = IntegerClsMydata.getData();

            System.out.println(stringValue);
            System.out.println(IntegerValue);


       
       
       
       
       
       
       
       
       
       
        }
    }
    


