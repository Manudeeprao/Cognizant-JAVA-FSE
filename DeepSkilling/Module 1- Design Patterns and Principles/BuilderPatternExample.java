public class BuilderPatternExample {

    // Product Class
    static class Computer {

        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private String operatingSystem;

        // Private Constructor
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
            this.operatingSystem = builder.operatingSystem;
        }

        public void showConfiguration() {
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram + " GB");
            System.out.println("Storage: " + storage + " GB");
            System.out.println("GPU: " + gpu);
            System.out.println("Operating System: " + operatingSystem);
            System.out.println("--------------------------");
        }

        // Static Nested Builder Class
        static class Builder {
            private String cpu;
            private int ram;
            private int storage;
            private String gpu;
            private String operatingSystem;

            public Builder setCPU(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRAM(int ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(int storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Test Class
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(2000)
                .setGPU("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(16)
                .setStorage(512)
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.showConfiguration();

        System.out.println("Office PC Configuration:");
        officePC.showConfiguration();
    }
}