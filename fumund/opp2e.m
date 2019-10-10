random = pi*rand;
x = linspace(0, pi, 51);
N = 50;
y = opp2(2.5, opp2(2.5, random, N), N);
plot(x,y)
hold 'on'
plot(x,x)