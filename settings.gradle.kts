pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Fire Notes"
include(":app")
include(":notes:ui")
include(":notes:data")
include(":notes:domain")
include(":auth:ui")
include(":auth:data")
include(":auth:domain")
include(":shared-notes:data")
include(":shared-notes:ui")
include(":shared-notes:domain")
