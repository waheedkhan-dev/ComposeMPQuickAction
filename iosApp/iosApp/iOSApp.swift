import SwiftUI
import ComposeApp

@UIApplicationMain
class AppDelegate: NSObject, UIApplicationDelegate {
    var window: UIWindow?
    let rinku = RinkuIos.init(deepLinkFilter: nil, deepLinkMapper: nil)
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        self.window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = UIHostingController(rootView: ContentView())
        self.window!.rootViewController = mainViewController
        self.window!.makeKeyAndVisible()
        
        return true
    }
    
    func application(_ application: UIApplication,
                     performActionFor shortcutItem: UIApplicationShortcutItem,
                     completionHandler: @escaping (Bool) -> Void) {
        // Handle the shortcut item
        let handled = handleQuickAction(shortcutItem)
        completionHandler(handled)
    }

    private func handleQuickAction(_ shortcutItem: UIApplicationShortcutItem) -> Bool {
        switch shortcutItem.type {
        case "org.wk.composempquickaction.quick.action":
            rinku.onDeepLinkReceived(url: "Hello from quick action")
            return true
        default:
            return false
        }
    }
}
