def truthTable(expression, num_of_vars):
    print("Boolean Expression:")
    print("  X = " + expression.upper())
    expression = expression.lower()

    # Replace Boolean Operators with bitwise operators
    operators = {
        "and": "&",
        "xor": "^",
        "or": "|",
        "not": "~",
        "nand": "not &",
        "xnor": "not ^"
    }
    for op, bitwise_op in operators.items():
        expression = expression.replace(op, bitwise_op)

    # Generate variable names
    variables = [chr(ord('A') + i) for i in range(num_of_vars)]

    # Print the header of the truth table
    header = "| " + " | ".join(variables) + " | X  |"
    line = "-" * len(header)
    print("\nTruth Table:")
    print(line)
    print(header)
    print(line)

    # Generate truth table rows
    for values in generate_variable_values(num_of_vars):
        value_str = "| " + " | ".join(map(str, values)) + " | "
        substitutions = {variables[i]: values[i] for i in range(num_of_vars)}
        substituted_expression = expression
        for var, value in substitutions.items():
            substituted_expression = substituted_expression.replace(var.lower(), str(value))
        x = eval(substituted_expression)
        print(value_str + str(int(x)).rjust(2) + " |")
        print("" + line)


def generate_variable_values(num_of_vars):
    # Generate all possible combinations of 0 and 1 for the given number of variables
    for i in range(2 ** num_of_vars):
        # Convert the decimal value to binary and then to a list of binary digits
        binary_value = bin(i)[2:].zfill(num_of_vars)
        yield [int(bit) for bit in binary_value]


# Example usage:
# expression = "(NOT A AND NOT B AND C) OR (A AND NOT B AND C)"
expression = "A AND B AND C AND D"
num_of_vars = 4
truthTable(expression, num_of_vars)
