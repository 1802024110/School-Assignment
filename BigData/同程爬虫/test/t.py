def my_decorator(func):
    def wrapper(*args, **kwargs):
        print("Before function call")
        result = func(*args, **kwargs)
        print("After function call")
        return result
    return wrapper

@my_decorator
def my_function():
    """This is a docstring for my_function"""
    print("Inside my_function")

print(my_function.__name__)  # Output: "wrapper"
print(my_function.__doc__)   # Output: None


from functools import wraps

def my_decorator(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        print("Before function call")
        result = func(*args, **kwargs)
        print("After function call")
        return result
    return wrapper

@my_decorator
def my_function():
    """This is a docstring for my_function"""
    print("Inside my_function")

print(my_function.__name__)  # Output: "my_function"
print(my_function.__doc__)   # Output: "This is a docstring for my_function"