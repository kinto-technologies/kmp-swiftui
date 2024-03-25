package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class BaseViewModel: ViewModel() {
    actual val viewModelScope = androidXViewModelScope

    actual override fun onCleared() {}
}
