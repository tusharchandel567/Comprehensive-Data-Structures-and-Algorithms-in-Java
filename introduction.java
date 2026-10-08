# Data Structures & Algorithms: Chapter 1 Notes (Intro, ADT, Big O)

## 1. Data → Information
- **Data** is raw facts. When it is arranged systematically, it becomes meaningful **information**.
- A **data structure** is a systematic way to organize data so it can be used efficiently.
- Program development = **data structures** (how to store the data) + **algorithms** (the step-by-step procedure).

## 2. Data Type vs ADT vs Data Structure

| Concept | Meaning | Example |
|---|---|---|
| **Data type** | A set of allowed values and the operations on them | `int`: values in a range; operations `+ - * /` |
| **ADT** (Abstract Data Type) | A *logical* description: **what** operations exist, not **how** they work | Stack ADT: `push`, `pop`, `peek` |
| **Data structure** | The *physical* implementation of an ADT: **how** it works | Stack built using an array or a linked list |

**Black box idea:** you use `int` without knowing how it is stored. In the same way, a stack user only calls `push()`/`pop()` and never sees the internals.

### The three ADTs
- **List:** ordered elements. Operations: `initialize, get, insert, remove, removeAt, replace, size, isEmpty, isFull`.
- **Stack (LIFO):** `push` and `pop` happen at the **top**. Also `peek, size, isEmpty, isFull`.
- **Queue (FIFO):** `enqueue` at the end, `dequeue` from the front. Also `peek, size, isEmpty, isFull`.

**Example:** a stack of plates. You add (push) and remove (pop) only from the top. A ticket line is a queue: the first person in is served first.

**Client vs implementation:**
- *Client* = a program that uses the data structure (e.g. balanced parentheses, infix to postfix).
- *Interface* = the ADT specification, the only thing the client sees.
- You can change the implementation from array to linked list and the client code still works.

**Advantages of data structures:** efficiency, reusability, abstraction.

**Example (efficiency):** to search 1,000 items in an unsorted array, you may check all 1,000. A binary search tree or hash table finds the item much faster.

**Common operations:** insertion, deletion, traversal, search.

## 3. Types of Data Structures

**Linear vs non-linear**
- **Linear:** every element has one predecessor and one successor (except the first and last). Examples: arrays, linked lists, stacks, queues.
- **Non-linear:** no single sequence. Examples: trees, graphs.

**Static vs dynamic**
- **Static:** memory is fixed at compile time, so the size can't change. Access is fast, but insertion and deletion are slow. Example: array.
- **Dynamic:** memory is allocated at run time, so the size is flexible. Insertion and deletion are fast, but access is slow. Example: linked list.

## 4. Algorithms
An **algorithm** is a well-defined set of steps to solve a problem. One problem can have many algorithms, for example many ways to sort. Algorithms are compared on **running time** (most important) and **memory used**.

### Design approaches

| Approach | Idea | Examples |
|---|---|---|
| **Greedy** | Pick the best choice *right now* and never reconsider. Hopes the local best leads to the global best (not always true). | Dijkstra, Prim, Kruskal, Huffman |
| **Divide & Conquer** | Split into smaller similar subproblems, solve them, then combine the results. | Merge sort, quick sort, binary search |
| **Backtracking** | Try an option. If it fails, undo it and try another (trial and error). | Eight Queens |
| **Randomized** | Uses random numbers to make decisions. | Quick sort with a random pivot |

**Greedy example (coin change):** to make ₹30 with coins 25, 10 and 1, greedy picks 25 and then five 1s, which is 6 coins. The optimal answer is 3 coins of 10. So greedy is not always optimal.

## 5. Analysis of Algorithms

### Two ways to measure running time
1. **Experimental:** write the code, run it, and measure the time. It has three problems:
   - It depends on the hardware and language.
   - You can only test limited inputs.
   - It is very time-consuming.
2. **Asymptotic (analytical):** study how running time **grows as input size `n` grows**. It is independent of hardware and covers all inputs. **This is the method used.**

**Example:** Algorithm A takes 2n steps. Algorithm B takes n² steps. At n = 10,000, A takes 20,000 steps while B takes 100 million. A is clearly better for large input.

## 6. Big O Notation

**Meaning:** Big O gives an **upper bound** on how fast a function grows.

**Definition:** `f(n)` is `O(g(n))` if there exist constants `c` and `n₀` such that `f(n) ≤ c·g(n)` for all `n ≥ n₀`.

**Example:** show that `5n + 4` is `O(n)`.
- Take c = 6, n₀ = 4. Then 5n + 4 ≤ 6n for all n ≥ 4. ✔
- So `5n + 4` is `O(n)`.

**Example:** show that `3n² + 4n + 7` is `O(n²)`.
- Take c = 5, n₀ = 6. Then 3n² + 4n + 7 ≤ 5n² for n ≥ 6. ✔

The constants are not unique. All that matters is that they *exist*.

### Growth order (slowest → fastest)
`1 < log n < n < n log n < n² < n³ < 2ⁿ < n!`

### Key rules
1. **Transitivity:** if f is O(g) and g is O(h), then f is O(h).
2. **Sum:** O(h) + O(h) = O(h).
3. **Sum of different orders:** take the **max**. O(n) + O(n²) → O(n²).
4. **Product:** O(h)·O(g) = O(h·g).
5. **Constant:** f(n) = C → **O(1)**.
6. **Ignore coefficients:** 67n → O(n).
7. **Polynomial of degree m** → O(nᵐ).
8. **nᵃ is O(nᵇ)** only if a ≤ b. So n³ is O(n⁴) but n⁴ is *not* O(n³).
9. **Log base doesn't matter.** log₂n and log₁₀n differ only by a constant factor.
10. **log n is O(n).** Also logᵏn is O(n).

## 7. How to Find Big O (3 steps)
1. **Keep only the fastest-growing term.** Drop the lower terms.
2. **Drop the coefficient.**
3. **Ignore the log base.**

**Why it works:** for f(n) = 3n² + 4n + 15 at n = 10, the 3n² term contributes 84.5%, the 4n term 11.3%, and the constant 4.2%. As n grows, the n² term dominates even more.

| f(n) | Big O |
|---|---|
| 45 | O(1) |
| 6n³ + 27log n + 2n | O(n³) |
| 8log n + 7n + 6 | O(n) |
| n log n + 5n + 81n² | O(n²) |
| log n + n log n | O(n log n) |
| 3n + 5n² + 7n³ + 2ⁿ | O(2ⁿ) |
| 4ⁿ + 6ⁿ + 9n⁵ | O(6ⁿ) |
| 7n + 6ⁿ + n! | O(n!) |

## 8. Tight vs Loose Upper Bound
`5n² + 4n + 8` is technically O(n²), O(n³), O(2ⁿ), and so on, because all of these are valid upper bounds.
- **Tight bound (O(n²)):** the smallest valid bound, and the one you should always give.
- **Loose bounds (O(n³), O(n!), …):** correct but not informative.

The 3-step method above always gives the tight bound.

## 9. Finding Time Complexity

**Idea:** count how many times each primitive operation (comparison, arithmetic, assignment, I/O) executes in terms of `n`. Ignore anything that runs a constant number of times. Focus on loops that depend on `n`.

### Loop patterns cheat sheet

| Loop pattern | Iterations | Complexity |
|---|---|---|
| `for(i=0; i<n; i++)` | n | **O(n)** |
| `for(i=n; i>=1; i=i-4)` or `i=i+5` (add/subtract a constant) | ⌈n/4⌉, ⌈n/5⌉ | **O(n)** |
| `for(i=n; i>=1; i/=2)` (divide) | ⌈log₂n⌉ | **O(log n)** |
| `for(i=1; i<=n; i*=2)` (multiply) | ⌈log₂n⌉ | **O(log n)** |
| `for(i=0; i<6; i++)` (fixed count) | 6 | **O(1)** |
| Nested: `for i<n { for j<n }` | n × n | **O(n²)** |
| Triple nested | n³ | **O(n³)** |
| Dependent: `for i<n { for j<=i }` | 1+2+…+n = n(n+1)/2 | **O(n²)** |
| Loop calling an O(log n) function | n × log n | **O(n log n)** |

### Worked examples

**Example A: sequential loops (add, then take the max)**
```
for(i=n-2; i>=1; i--)   → n-2 times
for(i=0; i<n; i++)      → n times
for(i=0; i<6; i++)      → 6 times (constant, ignore)
```
T(n) = (n−2) + n = 2n − 2 → **O(n)**

**Example B: nested loops (multiply)**
```
for(i=0; i<n; i++)
   for(j=0; j<n; j++)
       comparison;
```
Inner body runs n·n = n² times → **O(n²)**

**Example C: dependent nested loop (selection sort and bubble sort pattern)**
```
for(i=0; i<n; i++)
   for(j=0; j<=i; j++)
       op;
```
Runs 1 + 2 + 3 + … + n = n(n+1)/2 times → **O(n²)**

**Example D: loop with an inner log loop plus an inner linear loop**
```
for(i=0; i<n; i++){
    for(k=n; k>=1; k/=2) op;   // log n each time → n log n total
    for(j=0; j<n; j++) op;     // n each time → n² total
}
```
T(n) = n log n + n² → **O(n²)**

**Example E: if…else (take the larger branch)**
- if-block is O(n²), else-block is O(n) → the whole statement is **O(n²)**.

**Example F: constant time**
```
for(i=0; i<5; i++) op;
```
Always 5 steps → **O(1)**. Other O(1) examples: `printFirstElement()`, `swapFirstLast()`, `returnStackSize()`.

### Quick tricks to remember
- Sequential blocks → **add**, then keep the biggest.
- Nested loops → **multiply**.
- `i += c` or `i -= c` → **linear**.
- `i *= c` or `i /= c` → **logarithmic**.
- Fixed-count loop → **constant**.

## 10. Worst, Average and Best Case

Some algorithms take different time for different inputs of the same size.

| Case | Meaning | Linear search example |
|---|---|---|
| **Best** | Minimum time | Element at the 1st position → 1 comparison → **O(1)** |
| **Worst** | Maximum time | Element at the last position or not present → n comparisons → **O(n)** |
| **Average** | Average over all inputs | About n/2 comparisons → O(n) |

- **Worst case is the standard.** It gives a guarantee that the algorithm will never be slower than this. When the case isn't mentioned, worst case is assumed.
- Best case is not very useful because it rarely happens.
- Average case is rarely done because it is hard to calculate.

**Example:** an algorithm that is O(n²) worst, O(n log n) average and O(1) best is simply called **O(n²)**.

## 11. Common Complexities

| Big O | Name | Meaning / Example |
|---|---|---|
| O(1) | Constant | Time doesn't depend on n. Examples: insert at the beginning of a linked list, hash table lookup. |
| O(log n) | Logarithmic | Halves the data each step. Example: binary search. |
| O(n) | Linear | Process each element once. If n doubles, time doubles. Examples: print an array, linear search (worst case). |
| O(n log n) | Linearithmic | Examples: merge sort, best case of quick sort. |
| O(n²) | Quadratic | All pairs. If n doubles, time ×4. Examples: bubble sort and selection sort (worst case). |
| O(n³) | Cubic | All triplets. Example: matrix multiplication. |
| O(nᵏ) | Polynomial | Any constant k. |
| O(aⁿ) | Exponential | All subsets. Time doubles with each extra element (for 2ⁿ). Example: Tower of Hanoi. |
| O(n!) | Factorial | All permutations. |

Exponential and factorial algorithms are usable only for very small inputs.

## 12. Exercise Answers (for self-check)

| Q | Answer | Reason |
|---|---|---|
| 1 | False | Asymptotic analysis does *not* compute the exact time |
| 2 | True | |
| 3 | True | n grows faster than log n |
| 4 | fastest | |
| 5 | True | |
| 6 | O(n²) | |
| 7 | O(1) | constant |
| 8 | (c) f2, f1, f3 | log n < n² < 2ⁿ |
| 9 | False | 3ⁿ grows faster than n³ |
| 10 | O(n) | single loop |
| 11 | False | inner loop runs a fixed 5 times → O(n) |
| 12 | (b) O(n²) | n log n + n² |
| 13 | double | |
| 14 | Worst | |
| 15 | Average | |
| 16 | True | |
| 17 | O(1) | |
| 18 | findMax1 | it can stop early depending on where the max is |
| 19 | sum2 | O(n) vs sum1's O(n²) |

## One-Page Summary
- **ADT** = what it does. **Data structure** = how it does it.
- Efficiency is measured by **asymptotic analysis**, using **Big O** as the upper bound.
- To find Big O: drop the constants, coefficients and lower terms, and give the **tight** bound.
- Loops: sequential → add, nested → multiply, halving or doubling → log n.
- Analyse the **worst case** by default.

If you want these notes as a downloadable PDF or Word file, or a practice quiz from this chapter, tell me which and I'll make it.