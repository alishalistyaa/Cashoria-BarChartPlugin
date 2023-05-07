plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(files("/Users/alishalistya/VSCode/untitled/build/libs/untitled-1.0-SNAPSHOT.jar"))
    implementation(files("/Users/alishalistya/VSCode/Tubes-2-OOP-O08/build/libs/project.jar"))
}

tasks.test {
    useJUnitPlatform()
}