% %c)
% A = [4 6; 6 -1];
% [U, V] = eig(A)

% %d)
% A = [2 -1 3; 2 3 2; -1 0 2];
% [U, V] = eig(A)
% rref(A) %gj?r om matrisen til redusert trappeform

% %e)
% A =  [4 0 1; 2 3 2; -1 0 2];
% [U, V] = eig(A)
% rref(A)

% %f)
% A = [3 1 0 0; -1 1 0 0; 0 0 1 4; 0 0 1 4];
% [U, V] = eig(sym(A))
% rref(A)

%g)
A = [3 1 0 0; -1 1 0 0; 0 0 1 4; 0 0 1 4];
[U, V] = eig(A)
rref(A)