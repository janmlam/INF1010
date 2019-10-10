
function x = Func(a, x, N)
    for i=1:N
        random = pi*rand;
        f = a*sin(x(i));
        x(i+1) = f;
    end
end
