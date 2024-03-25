import UIKit
import SwiftUI
import ComposeApp

struct ContentView: View {
    
    @State private var inputText = ""
    
    var body: some View {
        ZStack {
            Color("TopGradient")
                .ignoresSafeArea()
            ComposeViewControllerRepresentable()
            TextInputView(inputText: $inputText)
        }
        .onTapGesture {
            // Hide keyboard on tap outside of TextField
            UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
        }
    }
}
