public class NoDesignPattern {

    public void step1(){
        System.out.println("step1");
    }

    public void step2(){
        System.out.println("step2");
    }
    public void step3(String S1){
        System.out.println("step3");
    }

    public static void main(String[] args) {
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Harika");
    }

}
