package vonglap;

public class Ascii {
    public static void main(String[] args) {
        String ascii[]={"(null)","(start of heading)","(start of text)","(end of text)","(end of transmission)","(enquiry)","(acknowledge)","(bell)","(backspace)","(horizontal tab)","(NL line feed, new line)"
                ,"(vertical tab)","(NP form feed, new page)","(carriage return)","(shift out)","(shift in)","(data link escape)","(device control 1)","(device control 2)","(device control 3)","(device control 4)"
                ,"(negative acknowledge)","(synchronous idle)","(end of trans. block)","(cancel)","(end of medium)"," (substitute)","(escape)","(file separator)","(group separator)","(record separator)","(unit separator)"};

        System.out.println("Bảng mã ASCII: ");
        for(int i=0;i<32;i++){
            System.out.println("   "+i+"   "+ascii[i]);
        }
        for(int i = 32; i < 127; ++i){
            System.out.println("   "+i+"   "+(char)i);
        }
        System.out.println("   "+127+"   (DElETE)");
    }
}
