"""
Описание и тесты в конце файла
"""
class Node:
  def __init__(self, value = 0, parent = None, left = None, right = None, height = 0):
    self.parent = parent
    self.left = left
    self.right = right
    self.h = height
    self.value = value

class avlTree:
  def __init__(self, root = None):
    self.root = root
    self.totalCount = 0
  
  def getRightDepth(self, node):
    if (node.right == None):
      return -1
    else:
      return node.right.h
  
  def getLeftDepth(self, node):
    if (node.left == None):
      return -1
    else:
      return node.left.h
  
  def getHeight(self, node):
    if (node == None):
      return -1
    else:
      return node.h
    
  def smallRightTurn(self, alfa):
    parentNode = alfa.parent
    betta = alfa.right
    B_C = betta.left

    betta.left = alfa
    alfa.parent = betta
    alfa.right = B_C
    try:
      B_C.parent = alfa
    except Exception:
      pass
    if (alfa.right == None and B_C == None):
      alfa.h = 0
    else:
      alfa.h = max(self.getHeight(alfa.left), self.getHeight(B_C)) + 1
    betta.h = max(self.getHeight(alfa), self.getHeight(betta.right)) + 1
    betta.parent = parentNode
    if (parentNode == None):
      self.root = betta
    else:
      if (parentNode.value > alfa.value):
        parentNode.left = betta
      else:
        parentNode.right = betta
  
  
  def smallLeftTurn(self, alfa):
    parentNode = alfa.parent
    betta = alfa.left
    B_C = betta.right

    betta.right = alfa
    alfa.parent = betta
    alfa.left = B_C
    try:
      B_C.parent = alfa
    except Exception:
      pass
    #if (self.getHeight(alfa.right) == 0 and self.getHeight(B_C) == 0):
    if (alfa.right == None and B_C == None):
      alfa.h = 0
    else:
      alfa.h = max(self.getHeight(alfa.right), self.getHeight(B_C)) + 1
    betta.h = max(self.getHeight(alfa), self.getHeight(betta.left)) + 1
    
    betta.parent = parentNode
    if (parentNode == None):
      self.root = betta
    else:
      if (parentNode.value > alfa.value):
        parentNode.left = betta
      else:
        parentNode.right = betta
  
  def bigRightTurn(self, alfa):
    parentNode = alfa.parent
    betta = alfa.right
    gamma = betta.left
    B = gamma.left
    C = gamma.right

    gamma.left = alfa
    alfa.parent = gamma
    alfa.right = B
    gamma.right = betta
    betta.parent = gamma
    betta.left = C
    try:
      B.parent = alfa
    except Exception:
      pass
    try:
      C.parent = betta
    except Exception:
      pass
    
    if (alfa.left == None and alfa.right == None):
      alfa.h = 0
    else:
      alfa.h = max(self.getHeight(alfa.left), self.getHeight(alfa.right)) + 1
    if (betta.left == None and betta.right == None):
      betta.h = 0
    else:
      betta.h = max(self.getHeight(betta.left), self.getHeight(betta.right)) + 1
    gamma.h = max(self.getHeight(alfa), self.getHeight(betta)) + 1

    gamma.parent = parentNode
    if (parentNode == None):
      self.root = gamma
    else:
      if (parentNode.value > alfa.value):
        parentNode.left = gamma
      else:
        parentNode.right = gamma
  
  def bigLeftTurn(self, alfa):
    parentNode = alfa.parent
    betta = alfa.left
    gamma = betta.right
    B = gamma.right
    C = gamma.left

    gamma.left = betta
    betta.parent = gamma
    betta.right = C
    gamma.right = alfa
    alfa.parent = gamma
    alfa.left = B
    try:
      B.parent = alfa
    except Exception:
      pass
    try:
      C.parent = betta
    except Exception:
      pass

    if (alfa.left == None and alfa.right == None):
      alfa.h = 0
    else:
      alfa.h = max(self.getHeight(alfa.left), self.getHeight(alfa.right)) + 1
    if (betta.left == None and betta.right == None):
      betta.h = 0
    else:
      betta.h = max(self.getHeight(betta.left), self.getHeight(betta.right)) + 1
    gamma.h = max(self.getHeight(alfa), self.getHeight(betta)) + 1

    gamma.parent = parentNode
    if (parentNode == None):
      self.root = gamma
    else:
      if (parentNode.value > alfa.value):
        parentNode.left = gamma
      else:
        parentNode.right = gamma
  
  def balance(self, node):
    parentNode = node.parent
    #if (self.getRightDepth(node) - self.getLeftDepth(node) >= 2): 
    if (self.getHeight(node.right) - self.getHeight(node.left) >= 2):
      rightChild = node.right
      #if (self.getRightDepth(rightChild) - self.getLeftDepth(rightChild) >= 1):
      if (self.getHeight(rightChild.right) - self.getHeight(rightChild.left) >= 1): 
        self.smallRightTurn(node)
      else:
        self.bigRightTurn(node)
    if (self.getHeight(node.left) - self.getHeight(node.right) >= 2):
      #print(str(node.value) + ' left', end=' ')
      leftChild = node.left
      if (self.getHeight(leftChild.left) - self.getHeight(leftChild.right) >= 1):
        self.smallLeftTurn(node)
      else:
        self.bigLeftTurn(node) 
    if (parentNode != None):
      self.balance(parentNode)

  def add(self, node, start = 'root'):
    node.parent = None
    node.right = None
    node.left = None
    node.h = 0
    if (self.root == None):
      self.root = node
      self.totalCount += 1
      return node
    if (start == 'root'):
      start = self.root
    if (start.value > node.value):
      if (start.left == None):
        start.left = node
        start.h = max(0, self.getHeight(start.right)) + 1
        node.parent = start
        self.totalCount += 1
        return node
      else:
        return self.add(node, start.left)
    else:
      if (start.right == None):
        start.right = node
        start.h = max(0, self.getHeight(start.left)) + 1
        node.parent = start
        self.totalCount += 1
        return node
      else:
        return self.add(node, start.right)
  
  def updateHeights(self, node):
    if (node == None):
      return
    node.h = max(self.getHeight(node.left), self.getHeight(node.right)) + 1
    self.updateHeights(node.parent)

  def insert(self, node):
    node = self.add(node)
    self.updateHeights(node)
    self.balance(node)
  
  def extractMin(self, node = 'root'):
    if self.totalCount == 0:
      return None

    if self.totalCount == 1:
      return self.root
      
    if (node == 'root'):
      node = self.root

    if (node.left != None):
      return self.extractMin(node.left)
    else:
      if(node.parent != None):
        node.parent.left = node.right
        self.updateHeights(node.parent)
        self.balance(node.parent)
      else:
        self.root = node.rigth
      self.totalCount -= 1
      node.parent = None
      return node
  
  def extractMax(self, node = 'root'):
    if self.totalCount == 0:
      return None

    if self.totalCount == 1:
      return self.root

    if (node == 'root'):
      node = self.root
    if (node.right != None):
      return self.extractMax(node.right)
    else:
      if(node.parent != None):
        node.parent.right = node.left
        self.updateHeights(node.parent)
        self.balance(node.parent)
      else:
        self.root = node.left
      self.totalCount -= 1
      node.parent = None
      return node
  
  def mergeWithRoot(self, node1, node2, tree):
    if (node1 == None or node2 == None):
      raise Exception('one of the nodes is undefined')
    if (node1.value == node2.value):
      raise Exception('unable to merge nodes with the same value')
    if (node1.value < node2.value):
      tree.left = node1
      tree.right = node2    
    else:
      tree.left = node2
      tree.right = node1
    node1.parent = tree
    node2.parent = tree
    return tree


def test1(k):# стандартный вариант работы без краевых случаев и прочих особенностей
  tree = avlTree()

  nodes = [Node(1), Node(3), Node(6), Node(10), Node(-1), Node(14), Node(17), Node(22)]
  for node in nodes:
    tree.insert(node)

  if k > tree.totalCount:
    raise Exception

  min_node = None
  for i in range(k):
    min_node = tree.extractMin()
  
  return min_node.value


def test2():# поиск минимума, когда 1 элемент в дереве
  tree = avlTree()
  node = Node(1)
  tree.insert(node)
  min_node = tree.extractMin()
  return min_node.value


def test3():# возвращаем None когда дерево пусто
  tree = avlTree()
  min_node = tree.extractMin()
  return min_node

"""
Идея: если есть бинарное дерево(мы решили, что это будет AVL-дерево), чтобы найти
k-ый минимум достаточно вызвать у дерева extractMin k раз
"""

k = 3
assert test1(k) == 3, "test1 failed"
assert test2() == 1, "test2 failed"
assert test3() is None, "test3 failed"
