import SwiftUI

struct TextInputView: View {
    
    @Binding var inputText: String
    @FocusState private var isFocused: Bool

    var body: some View {
        VStack {
            Spacer()
            HStack {
                TextField("Type message...", text: $inputText, axis: .vertical)
                    .focused($isFocused)
                    .lineLimit(3)
                if (!inputText.isEmpty) {
                    Button {
                        sendMessage(inputText)
                        isFocused = false
                        inputText = ""
                    } label: {
                        Image(systemName: "arrow.up.circle.fill")
                            .tint(Color(red: 0.671, green: 0.365, blue: 0.792))
                    }
                }
            }
            .padding(15)
            .background(RoundedRectangle(cornerRadius: 200).fill(.white).opacity(0.95))
            .padding(15)
        }
    }
}
