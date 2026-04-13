def power(base, exp, mod):
    # Fast modular exponentiation
    return pow(base, exp, mod)  # Python built-in handles this!

# Public parameters
p = int(input("Enter prime number p: "))
g = int(input("Enter primitive root g: "))
# Private keys
a = int(input("Alice's private key a: "))
b = int(input("Bob's private key b: "))
# Step 1: Compute public keys
A = power(g, a, p)  # Alice sends A to Bob
B = power(g, b, p)  # Bob sends B to Alice
print(f"\nAlice's public key A = {A}")
print(f"Bob's public key   B = {B}")
# Step 2: Compute shared secret
shared_alice = power(B, a, p)
shared_bob   = power(A, b, p)
print(f"Shared secret (Alice): {shared_alice}")
print(f"Shared secret (Bob):   {shared_bob}")
print(f"Keys match: {shared_alice == shared_bob}")
