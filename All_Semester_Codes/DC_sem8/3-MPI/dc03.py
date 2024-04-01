
3
4
5
from mpi4py import MPI
import time
import math

def compute_square(number):
    return number ** 2

def gcd(a, h):
    temp = 0
    while 1:
        temp = a % h
        if temp == 0:
            return h
        a = h
        h = temp

def rsa_encrypt(msg, e, n):
    return pow(msg, e, n)

def rsa_decrypt(c, d, n):
    return pow(c, d, n)

def main():
    comm = MPI.COMM_WORLD
    rank = comm.Get_rank()
    size = comm.Get_size()

    numbers = [2, 4, 6]
    results = []

    p = 53
    q = 59
    msg=89
    n = p * q
    e = 3
    z = (p - 1) * (q - 1)

    while e < z:
        if gcd(e, z) == 1:
            break
        else:
            e = e + 1

    k = 2
    d = pow(e, -1, z)

    if rank == 0:
        start_time = time.time()

    for i in range(rank, len(numbers), size):
        number = numbers[i]
        result = compute_square(number)
        encrypted_result = rsa_encrypt(result, e, n)
        decrypted_result = rsa_decrypt(encrypted_result, d, n)
        results.append(decrypted_result)

    if rank == 0:
        end_time = time.time()
        print("Given data: p=",p,", q=",q, ", e=",e," msg= ",msg,"\nn=n=p*q=",p,"*",q,"=",n, ", phi(n)= ",z)
        print("d=M.I. of",e,"in domain ",z,"= ",d)
        # Encryption c = (msg ^ e) % n
        c = pow(msg, e, n)
        print("Encrypted data = ", c)
        # Decryption m = (c ^ d) % n
        m = pow(c, d, n)
        print("Original Message Sent = ", m)
        print("Execution time:", end_time - start_time, "seconds")

if __name__ == "__main__":
    main()
6


