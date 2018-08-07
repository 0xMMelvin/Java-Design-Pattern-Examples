abstract class CPU {

} // class CPU

abstract class MMU {

} // class CPU

class EmberCPU extends CPU {

} // class EmberCPU

class EmberMMU extends MMU {

} // class EmberMMU

class EnginolaCPU extends CPU {

} // class EmberCPU

class EnginolaMMU extends MMU {

} // class EnginolaMMU

class EmberToolkit extends ArchitectureToolkit {
    public CPU createCPU() {
        return new EmberCPU();
    } // createCPU()

    public MMU createMMU() {
        return new EmberMMU();
    } // createMMU()

} // class EmberFactory

class EnginolaToolkit extends ArchitectureToolkit {
    public CPU createCPU() {
        return new EnginolaCPU();
    } // createCPU()

    public MMU createMMU() {
        return new EmberMMU();
    } // createMMU()
}

abstract class ArchitectureToolkit {
    private static final EmberToolkit emberToolkit = new EmberToolkit();
    private static final EnginolaToolkit enginolaToolkit = new EnginolaToolkit();
    public static final int ENGINOLA = 0;
    public static final int EMBER = 1;


    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static final ArchitectureToolkit getFactory(int architecture) {
        switch (architecture) {
            case 0: // ENGINOLA:
                return enginolaToolkit;

            case 1: // EMBER:
                return emberToolkit;
        } // switch
        String errMsg = Integer.toString(architecture);
        throw new IllegalArgumentException(errMsg);
    } // getFactory()

    public abstract CPU createCPU();

    public abstract MMU createMMU();
} // AbstractFactory

class Client {
    public void doIt() {
        ArchitectureToolkit abstractFactory;
        abstractFactory = ArchitectureToolkit.getFactory(ArchitectureToolkit.EMBER);
        CPU cpu = abstractFactory.createCPU();
        MMU mmu = abstractFactory.createMMU();
    } // doIt
} // class Client

