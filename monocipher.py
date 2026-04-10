ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
KEY   = "QWERTYUIOPASDFGHJKLZXCVBNM"

def encrypt(text):
    result = ""
    for ch in text.upper():
        if ch.isalpha():
            result += KEY[ALPHA.index(ch)]
        else:
            result += ch
    return result

def decrypt(text):
    result = ""
    for ch in text.upper():
        if ch.isalpha():
            result += ALPHA[KEY.index(ch)]
        else:
            result += ch
    return result

plain = input("Enter plaintext: ")
encrypted = encrypt(plain)
decrypted = decrypt(encrypted)

print("Encrypted:", encrypted)
print("Decrypted:", decrypted)
