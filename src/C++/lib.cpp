#include <string>


extern "C" const char* getNativeString(int x) {
    static thread_local std::string result;
    result = std::to_string(x) + " from the shared library!";
    return result.c_str();
}