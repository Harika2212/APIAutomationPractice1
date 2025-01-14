public class BuilderPatternJava {

   public BuilderPatternJava floor1(){
       System.out.println("Floor1");
       return this;
   }
    public BuilderPatternJava floor2(String S2){
        System.out.println("Floor2");
        return this;
    }
    public BuilderPatternJava floor3(){
        System.out.println("Floor3");
        return this;
    }

    public static void main(String[] args) {
        BuilderPatternJava bp = new BuilderPatternJava();
        bp.floor1().floor2("Harika M").floor3();
    }

}
