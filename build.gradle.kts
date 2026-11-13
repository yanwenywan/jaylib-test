plugins {
    id("java")
    id("application")
    id("distribution")
}

group = "yanwenyuan.jaylibtest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("uk.co.electronstudio.jaylib:jaylib:6.2.+")

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "yanwenyuan.jaylibtest.Main"
}

distributions {
    main {
        contents {
            from("assets") { into("assets") }
        }
    }
}

tasks.withType<CreateStartScripts>().configureEach {
    doLast {
        unixScript.writeText( unixScript.readText().replace(
            $$"exec \"$JAVACMD\" \"$@\"",
            $$"cd \"$APP_HOME\" || exit 1\nexec \"$JAVACMD\" \"$@\""
        ))
        windowsScript.writeText(windowsScript.readText().replace(
            ":execute",
            ":execute\r\ncd /d \"%APP_HOME%\""
        ))
    }
}

tasks.test {
    useJUnitPlatform()
}