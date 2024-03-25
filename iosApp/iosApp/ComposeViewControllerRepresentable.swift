import UIKit
import SwiftUI
import ComposeApp

struct ComposeViewControllerRepresentable : UIViewControllerRepresentable {
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainViewControllerKt.ComposeEntryPoint()
    }
}
