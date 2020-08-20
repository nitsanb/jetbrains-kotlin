class OperatingSystem {
    var name: String = "default"
}

class DualBoot {
    var primaryOs: OperatingSystem = OperatingSystem()
    var secondaryOs: OperatingSystem = OperatingSystem()
}