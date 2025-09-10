
@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHomeLightining {
    public static void main(String[] args) {
        
        LightAction motionTrigger = () -> System.out.println("Motion detected → Turn ON lights softly.");
        LightAction nightTrigger = () -> System.out.println("Night time → Dim lights to 30%.");
        LightAction voiceCommand = () -> System.out.println("Voice command → Turn OFF all lights.");

        
        motionTrigger.execute();
        nightTrigger.execute();
        voiceCommand.execute();
    }
}
