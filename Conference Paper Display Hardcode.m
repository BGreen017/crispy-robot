%% Conference Paper display

clear all


% Sample Data 
Map = [[0 10 10 0 0];[0 0 10 10 0]];
X = [[1 3 4 8 2 6 8 9];[4 3 7 2 7 1 9 7]];
Y = [[1 9 3 6];[1 9 6 3]];

xAxMin=min(Map(1,:))-3;
xAxMax=max(Map(1,:))+3;
yAxMin=min(Map(2,:))-3;
yAxMax=max(Map(2,:))+3;


n_UAVs = length(Y);
N_iterations = ceil(length(X)/n_UAVs);
Mdl = ExhaustiveSearcher(X');
[Idx, D] = knnsearch(Mdl,Y','K',N_iterations);

UAV = ones(n_UAVs,2*N_iterations);

for ii = 1:N_iterations
     UAV_index = Idx(1:n_UAVs,ii); 
     for jj = 1:length(Y)
        UAV(jj,(2*ii-1):(2*ii)) = X(1:2,UAV_index(jj));
     end
end

UAV_Path = [Y' UAV];

figure
title('UAV Objective Allocation')
xlabel('x')
ylabel('y')
axis([xAxMin xAxMax yAxMin yAxMax]);
hold on
p1 = plot(Map(1,:),Map(2,:),'--');
p1.LineWidth = 5;
p1.Color = 'k';
s1 = scatter(Y(1,:),Y(2,:),'o');
s2 = scatter(X(1,:),X(2,:),'V');
s1.LineWidth = .9;
s1.MarkerEdgeColor = 'k';
s2.LineWidth = .9;
s2.MarkerEdgeColor = 'k';


for ii = 1:n_UAVs
    x = [];
    y = [];
    for jj = 1:(N_iterations+1)
        x = [x UAV_Path(ii,(2*jj-1))];
        y = [y UAV_Path(ii,(2*jj))];
    end
    p2 = plot(x,y,'k');
end
legend([p1 p2 s1 s2],'Search Terrain','UAV Path','UAV','Objectives');

hold off
